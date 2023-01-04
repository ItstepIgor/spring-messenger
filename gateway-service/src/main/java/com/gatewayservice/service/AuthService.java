package com.gatewayservice.service;

import com.gatewayservice.entity.Users;
import com.gatewayservice.entity.jwt.AuthRequest;
import com.gatewayservice.util.UserRestTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {


    private final UserRestTemplate userRestTemplate;



    public void login(AuthRequest authRequest) {

        ResponseEntity<Users> response = userRestTemplate.userExists(authRequest);
        if (response.getBody() != null){

        }
    }
}
