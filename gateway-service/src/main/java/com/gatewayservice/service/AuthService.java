package com.gatewayservice.service;

import com.gatewayservice.entity.jwt.AuthRequest;
import com.gatewayservice.util.UserRestTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {


    private final UserRestTemplate userRestTemplate;



    public void login(AuthRequest authRequest) {

        userRestTemplate.userExists(authRequest);
    }
}
