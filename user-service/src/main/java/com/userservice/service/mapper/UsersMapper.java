package com.userservice.service.mapper;

import com.userservice.dto.UsersDto;
import com.userservice.entity.Users;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsersMapper {

    UsersDto usersToUsersDto(Users users);

    Users usersDtoToUsers(UsersDto usersDto);
}
