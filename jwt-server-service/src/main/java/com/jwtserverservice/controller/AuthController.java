package com.jwtserverservice.controller;


import com.jwtserverservice.entity.jwt.AuthRequest;
import com.jwtserverservice.entity.jwt.AuthResponse;
import com.jwtserverservice.entity.jwt.RefreshJwtRequest;
import com.jwtserverservice.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/jwt")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/token")
    public ResponseEntity<AuthResponse> getNewToken(@RequestBody AuthRequest authRequest) {
        final AuthResponse token = authService.getNewTokens(authRequest);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/access")
    public ResponseEntity<AuthResponse> getNewAccessToken(@RequestBody RefreshJwtRequest request) {
        final AuthResponse token = authService.getAccessToken(request.getRefreshToken());
        return ResponseEntity.ok(token);
    }

    //TODO если оставить только этот метод и сделать его публичным то при каждом запросе нового токена access токена
    // будет выдаваться новый refresh токен(будет использован только один раз) и сохраняться в БД
    @PostMapping("/refresh")
    public ResponseEntity<AuthResponse> getNewRefreshToken(@RequestBody RefreshJwtRequest request) {
        final AuthResponse token = authService.refresh(request.getRefreshToken());
        return ResponseEntity.ok(token);
    }

}
