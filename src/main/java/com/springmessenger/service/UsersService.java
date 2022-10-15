package com.springmessenger.service;

import com.springmessenger.dto.CreateUsersDto;
import com.springmessenger.dto.UsersDto;
import com.springmessenger.entity.Users;
import com.springmessenger.repository.UsersRepository;
import com.springmessenger.service.mapper.UsersListMapper;
import com.springmessenger.service.mapper.UsersMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;

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
                .password(createUsersDto.getPassword())
                .avatarId(createUsersDto.getAvatarId())
                .build();
        return usersMapper.usersToUsersDto(usersRepository.save(users));
    }

    public UsersDto update(UsersDto usersDto) {
        return usersMapper.usersToUsersDto(usersRepository.save(usersMapper.usersDtoToUsers(usersDto)));
    }
}
