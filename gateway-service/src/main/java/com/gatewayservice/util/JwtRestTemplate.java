package com.gatewayservice.util;

import com.gatewayservice.entity.jwt.AuthRequest;
import com.gatewayservice.entity.jwt.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class JwtRestTemplate {
    @Value("${base.url.rest.template.jwt}")
    private String url;

    private static final String baseUrlUser = "/api/jwt/";

    public ResponseEntity<AuthResponse> getToken(AuthRequest authRequest) {

        HttpEntity<AuthRequest> request = new HttpEntity<>(authRequest);

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.exchange(url + baseUrlUser + "/token", HttpMethod.POST, request, AuthResponse.class);
    }
}
