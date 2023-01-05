package com.jwtserverservice.service;

import com.jwtserverservice.entity.Users;
import com.jwtserverservice.entity.jwt.AuthRequest;
import com.jwtserverservice.entity.jwt.JwtProvider;
import com.jwtserverservice.entity.jwt.JwtRefreshToken;
import com.jwtserverservice.entity.jwt.AuthResponse;
//import com.jwtserverservice.exception.AuthException;
//import com.jwtserverservice.exception.BadLoginOrPasswordException;
import com.jwtserverservice.security.JwtAuthentication;
import com.jwtserverservice.util.UserFeignClients;
import com.jwtserverservice.util.UserRestTemplate;
import io.jsonwebtoken.Claims;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private static final String EXCEPTION_MESSAGE = "Не верный логин или пароль";
    //    private final UsersService userService;
    private final JwtProvider jwtProvider;

    private final UserRestTemplate userRestTemplate;

    private final UserFeignClients userFeignClients;
    private final JwtRefreshTokenService jwtRefreshTokenService;

    public AuthResponse getNewTokens(@NonNull AuthRequest authRequest) {
//получение user через RestTemplate
//        ResponseEntity<Users> response = userRestTemplate.userExists(authRequest);

        ResponseEntity<Users> response = userFeignClients.findByUserLogin(authRequest);

        System.out.println(response.getBody());
        final Users user = response.getBody();
        if (user != null) {
            final String accessToken = jwtProvider.generateAccessToken(response.getBody());
            final String refreshToken = jwtProvider.generateRefreshToken(response.getBody());
            return new AuthResponse(accessToken, refreshToken);
        }

//        return response.getBody();

//            saveToken(user, refreshToken);

//        } else {
//            throw new BadLoginOrPasswordException(EXCEPTION_MESSAGE);
//        }
        return null;
    }

    public AuthResponse getAccessToken(@NonNull String refreshToken) {
        if (!jwtProvider.validateRefreshToken(refreshToken)) {
            return new AuthResponse(null, null);
        }

        final Claims claims = jwtProvider.getRefreshClaims(refreshToken);
        final String login = claims.getSubject();
        final String saveRefreshToken = jwtRefreshTokenService.findByName(login).getToken();

        if (saveRefreshToken == null || !saveRefreshToken.equals(refreshToken)) {
            return new AuthResponse(null, null);
        }

//        final Users user = userService.findByUserLogin(login)
//                .orElseThrow(() -> new BadLoginOrPasswordException(EXCEPTION_MESSAGE));
//        final String accessToken = jwtProvider.generateAccessToken(user);

//        return new JwtResponse(accessToken, null);
        return null;
    }

    public AuthResponse refresh(@NonNull String refreshToken) {
//        if (!jwtProvider.validateRefreshToken(refreshToken)) {
//            throw new AuthException("Невалидный JWT токен");
//        }

        final Claims claims = jwtProvider.getRefreshClaims(refreshToken);
        final String login = claims.getSubject();
        final String saveRefreshToken = jwtRefreshTokenService.findByName(login).getToken();

//        if (saveRefreshToken == null || !saveRefreshToken.equals(refreshToken)) {
//            throw new AuthException("Невалидный JWT токен");
//        }

//        final Users user = userService.findByUserLogin(login)
//                .orElseThrow(() -> new BadLoginOrPasswordException(EXCEPTION_MESSAGE));
//        final String accessToken = jwtProvider.generateAccessToken(user);
//        final String newRefreshToken = jwtProvider.generateRefreshToken(user);
//        saveToken(user, newRefreshToken);

//        return new JwtResponse(accessToken, newRefreshToken);
        return null;
    }

    private void saveToken(Users user, String refreshToken) {
        JwtRefreshToken token = JwtRefreshToken.builder()
                .name(user.getName())
                .token(refreshToken)
                .build();
        jwtRefreshTokenService.save(token);
    }

    public JwtAuthentication getAuthInfo() {
        return (JwtAuthentication) SecurityContextHolder.getContext().getAuthentication();
    }
}
