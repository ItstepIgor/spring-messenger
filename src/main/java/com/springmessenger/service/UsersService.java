package com.springmessenger.service;

import com.springmessenger.dto.CreateUsersDto;
import com.springmessenger.dto.UsersDto;
import com.springmessenger.entity.Role;
import com.springmessenger.entity.Users;
import com.springmessenger.exception.AuthException;
import com.springmessenger.repository.UsersRepository;
import com.springmessenger.service.mapper.UsersListMapper;
import com.springmessenger.service.mapper.UsersMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersService implements UserDetailsService {

    private final UsersRepository usersRepository;

    private final PasswordEncoder passwordEncoder;

    private final UsersListMapper usersListMapper;

    private final UsersMapper usersMapper;

    public List<UsersDto> findAll() {
        return usersListMapper.listUsersToListUsersDto(usersRepository.findAll());
    }

    public UsersDto findById(Long id) {
        return usersMapper.usersToUsersDto(usersRepository.findById(id).orElse(null));
    }

    public void delete(long id) {
        usersRepository.deleteById(id);
    }

    public UsersDto save(CreateUsersDto createUsersDto) {
        Users users = Users.builder()
                .name(createUsersDto.getName())
                .password(passwordEncoder.encode(createUsersDto.getPassword()))
                .avatarId(createUsersDto.getAvatarId())
                .role(Role.valueOf(createUsersDto.getRole()))
                .build();
        return usersMapper.usersToUsersDto(usersRepository.save(users));
    }

    public UsersDto update(UsersDto usersDto) {
        Users entity = usersMapper.usersDtoToUsers(usersDto);
        Users save = usersRepository.save(entity);

        return usersMapper.usersToUsersDto(save);
    }

    public Optional<Users> findByUserLogin(String username) {
        return usersRepository.findUsersByName(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = findByUserLogin(username)
                .orElseThrow(() -> new AuthException("Пользователь не найден"));
        if (users == null) {
            throw new UsernameNotFoundException("Пользователь " + username + " не существует");
        }
        return User.builder()
                .username(users.getName())
                .password(users.getPassword())
                .roles(String.valueOf(users.getRole()))
                .build();
    }
}
