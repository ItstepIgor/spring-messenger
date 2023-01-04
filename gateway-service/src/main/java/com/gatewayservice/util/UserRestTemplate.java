package com.gatewayservice.util;

import com.gatewayservice.entity.Users;
import com.gatewayservice.entity.jwt.AuthRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class UserRestTemplate {
    @Value("${base.url.rest.template}")
    private String url;

    private static final String baseUrlUser = "/api/users/";

    public ResponseEntity<Users> userExists(AuthRequest authRequest) {

        HttpEntity<AuthRequest> request = new HttpEntity<>(authRequest);

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.exchange(url + baseUrlUser + "/login", HttpMethod.POST, request, Users.class);

    }

}
