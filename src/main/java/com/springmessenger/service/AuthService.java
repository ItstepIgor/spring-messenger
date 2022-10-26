package com.springmessenger.service;

import com.springmessenger.entity.Users;
import com.springmessenger.entity.jwt.JwtProvider;
import com.springmessenger.entity.jwt.JwtRefreshToken;
import com.springmessenger.entity.jwt.JwtRequest;
import com.springmessenger.entity.jwt.JwtResponse;
import com.springmessenger.exception.AuthException;
import com.springmessenger.exception.BadLoginOrPasswordException;
import com.springmessenger.security.JwtAuthentication;
import io.jsonwebtoken.Claims;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private static final String EXCEPTION_MESSAGE = "Не верный логин или пароль";
    private final UsersService userService;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;
    private final JwtRefreshTokenService jwtRefreshTokenService;

    public JwtResponse login(@NonNull JwtRequest authRequest) {
        final Users user = userService.findByUserLogin(authRequest.getLogin())
                .orElseThrow(() -> new BadLoginOrPasswordException(EXCEPTION_MESSAGE));
        if (passwordEncoder.matches(authRequest.getPassword(), user.getPassword())) {
            final String accessToken = jwtProvider.generateAccessToken(user);
            final String refreshToken = jwtProvider.generateRefreshToken(user);

            saveToken(user, refreshToken);

            return new JwtResponse(accessToken, refreshToken);
        } else {
            throw new BadLoginOrPasswordException(EXCEPTION_MESSAGE);
        }
    }

    public JwtResponse getAccessToken(@NonNull String refreshToken) {
        if (!jwtProvider.validateRefreshToken(refreshToken)) {
            return new JwtResponse(null, null);
        }

        final Claims claims = jwtProvider.getRefreshClaims(refreshToken);
        final String login = claims.getSubject();
        final String saveRefreshToken = jwtRefreshTokenService.findByName(login).getToken();

        if (saveRefreshToken == null || !saveRefreshToken.equals(refreshToken)) {
            return new JwtResponse(null, null);
        }

        final Users user = userService.findByUserLogin(login)
                .orElseThrow(() -> new BadLoginOrPasswordException(EXCEPTION_MESSAGE));
        final String accessToken = jwtProvider.generateAccessToken(user);

        return new JwtResponse(accessToken, null);
    }

    public JwtResponse refresh(@NonNull String refreshToken) {
        if (!jwtProvider.validateRefreshToken(refreshToken)) {
            throw new AuthException("Невалидный JWT токен");
        }

        final Claims claims = jwtProvider.getRefreshClaims(refreshToken);
        final String login = claims.getSubject();
        final String saveRefreshToken = jwtRefreshTokenService.findByName(login).getToken();

        if (saveRefreshToken == null || !saveRefreshToken.equals(refreshToken)) {
            throw new AuthException("Невалидный JWT токен");
        }

        final Users user = userService.findByUserLogin(login)
                .orElseThrow(() -> new BadLoginOrPasswordException(EXCEPTION_MESSAGE));
        final String accessToken = jwtProvider.generateAccessToken(user);
        final String newRefreshToken = jwtProvider.generateRefreshToken(user);
        saveToken(user, newRefreshToken);

        return new JwtResponse(accessToken, newRefreshToken);
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
