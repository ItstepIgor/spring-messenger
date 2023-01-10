package com.authorizationservice.service;

import com.authorizationservice.util.UserFeignClients;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthorizationService {
    private final UserFeignClients userFeignClients;
}
