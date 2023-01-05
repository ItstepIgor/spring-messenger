package com.gatewayservice.service;

import com.gatewayservice.entity.jwt.AuthRequest;
import com.gatewayservice.entity.jwt.AuthResponse;
import com.gatewayservice.util.JwtRestTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {


    private final JwtRestTemplate jwtRestTemplate;

    public ResponseEntity<AuthResponse> login(AuthRequest authRequest) {

        return jwtRestTemplate.getToken(authRequest);
    }
}
