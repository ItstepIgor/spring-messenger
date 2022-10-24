package com.springmessenger.dto;


import com.springmessenger.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDto {

    private long id;

    private String name;

    private String password;

    private String avatarId;

    private Role role;

}
