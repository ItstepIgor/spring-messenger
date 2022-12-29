package com.userservice.service;

import com.userservice.dto.CreateUsersDto;
import com.userservice.dto.UsersDto;
import com.userservice.entity.AuthRequest;
import com.userservice.entity.Role;
import com.userservice.entity.Users;
import com.userservice.repository.UsersRepository;
import com.userservice.service.mapper.UsersListMapper;
import com.userservice.service.mapper.UsersMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersService /*implements UserDetailsService*/ {

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
//                .password("4646")
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

    //TODO Security вернуть
//    public Optional<Users> findByUserLogin(String username) {
    public Users findByUserLogin(AuthRequest authRequest) {
// //       Optional<Users> optionalUsers = usersRepository.findUsersByName(authRequest.getLogin());
        return usersRepository.findUsersByName(authRequest.getLogin());


//
////        return optionalUsers.isPresent();
//
////                .orElseThrow(() -> new BadLoginOrPasswordException(EXCEPTION_MESSAGE));
//        if (passwordEncoder.matches(authRequest.getPassword(), optionalUsers.get().getPassword())) {
//
//            return true;
//        } else {
//            return false;
////            throw new BadLoginOrPasswordException(EXCEPTION_MESSAGE);
//        }


    }


    //TODO 27/10/2022 выяснить зачем метод нужен для выполнения тестов если его нет ошибка Stack Overflow
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return null;
//    }
}
