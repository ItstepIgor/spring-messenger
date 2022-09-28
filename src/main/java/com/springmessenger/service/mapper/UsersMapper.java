package com.springmessenger.service.mapper;

import com.springmessenger.dto.UsersDto;
import com.springmessenger.entity.Users;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsersMapper {

    UsersDto usersToUsersDto(Users users);

    Users usersDtoToUsers(UsersDto usersDto);
}
