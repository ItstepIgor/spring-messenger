package com.gatewayservice.service;

import com.gatewayservice.entity.jwt.AuthRequest;
import com.gatewayservice.feign.UserFeignClients;
import com.gatewayservice.feign.UserWebClients;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserFeignClients userFeignClients;

    private final UserWebClients userWebClients;

    public void login(AuthRequest authRequest) {

//        return userFeignClients.findByUserLogin(authRequest);
//        return userWebClients.userExists(authRequest);
        userWebClients.userExists(authRequest);
    }
}
