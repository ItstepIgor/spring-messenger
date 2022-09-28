package com.springmessenger.service;

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

    public void delete(UsersDto usersDto) {
        usersRepository.delete(usersMapper.usersDtoToUsers(usersDto));
    }

    public Users save(Users users) {
        return usersRepository.save(users);
    }

    public Users update(Users users) {
        return usersRepository.save(users);
    }
}
