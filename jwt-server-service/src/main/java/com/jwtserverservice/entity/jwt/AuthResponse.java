package com.jwtserverservice.entity.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class AuthResponse {
    private static final String TYPE = "Bearer";
    private String accessToken;
    private String refreshToken;
}
