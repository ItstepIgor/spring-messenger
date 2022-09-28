package com.springmessenger.service.mapper;


import com.springmessenger.dto.UsersDto;
import com.springmessenger.entity.Users;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = UsersMapper.class)
public interface UsersListMapper {

    List<UsersDto> listUsersToListUsersDto(List<Users> users);

    List<Users> listUsersDtoToListUsers(List<UsersDto> usersDto);
}
