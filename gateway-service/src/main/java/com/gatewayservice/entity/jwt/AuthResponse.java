package com.gatewayservice.entity.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    private static final String TYPE = "Bearer";
    private String accessToken;
    private String refreshToken;
}
