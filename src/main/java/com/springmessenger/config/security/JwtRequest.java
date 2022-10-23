package com.springmessenger.config.security;

import lombok.Data;

@Data
public class JwtRequest {
    private String login;
    private String password;
}
