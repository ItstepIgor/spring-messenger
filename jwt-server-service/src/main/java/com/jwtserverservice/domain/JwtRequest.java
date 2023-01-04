package com.jwtserverservice.domain;

import lombok.Data;

@Data
public class JwtRequest {
    private String login;
    private String password;
}
