package com.userservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateUsersDto {
    private String name;
    private String password;
    private String avatarId;
    private String role;
}