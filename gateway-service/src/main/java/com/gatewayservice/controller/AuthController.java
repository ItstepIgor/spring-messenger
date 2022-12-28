package com.gatewayservice.controller;


import com.gatewayservice.entity.Users;
import com.gatewayservice.entity.jwt.JwtRequest;
import com.gatewayservice.entity.jwt.JwtResponse;
import com.gatewayservice.entity.jwt.RefreshJwtRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/authenticate")
public class AuthController {

//    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<Users> login(@RequestBody JwtRequest authRequest) {
        final JwtResponse token = authService.login(authRequest);
        return ResponseEntity.ok(token);
    }

//    @PostMapping("/token")
//    public ResponseEntity<JwtResponse> getNewAccessToken(@RequestBody RefreshJwtRequest request) {
//        final JwtResponse token = authService.getAccessToken(request.getRefreshToken());
//        return ResponseEntity.ok(token);
//    }
//
//    //TODO если оставить только этот метод и сделать его публичным то при каждом запросе нового токена access токена
//    // будет выдаваться новый refresh токен(будет использован только один раз) и сохраняться в БД
//    @PostMapping("/refresh")
//    public ResponseEntity<JwtResponse> getNewRefreshToken(@RequestBody RefreshJwtRequest request) {
//        final JwtResponse token = authService.refresh(request.getRefreshToken());
//        return ResponseEntity.ok(token);
//    }

}