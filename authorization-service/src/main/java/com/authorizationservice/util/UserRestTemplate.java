package com.authorizationservice.util;

import com.authorizationservice.entity.AuthRequest;
import com.authorizationservice.entity.Users;
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
//    @Value("${base.url.rest.template.jwt}")
//    private String url;

//    private static final String baseUrlUser = "/api/jwt/";

    public ResponseEntity<Users> getUser(String login) {

        HttpEntity<String> request = new HttpEntity<>(login);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Users> exchange = restTemplate.exchange("http://localhost:8082/api/users/login", HttpMethod.POST, request, Users.class);

        return exchange;
    }
}
