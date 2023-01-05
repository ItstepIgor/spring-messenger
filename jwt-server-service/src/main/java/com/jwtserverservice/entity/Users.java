package com.jwtserverservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Users {
    private long id;
    private String name;
    private String password;
    private String avatarId;
    private Role role;
}
