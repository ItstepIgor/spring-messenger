package com.springmessenger.service;

import com.springmessenger.config.security.JwtAuthentication;
import com.springmessenger.config.security.JwtProvider;
import com.springmessenger.config.security.JwtRequest;
import com.springmessenger.config.security.JwtResponse;
import com.springmessenger.entity.Users;
import com.springmessenger.exception.AuthException;
import io.jsonwebtoken.Claims;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthService {

    private static final String EXCEPTION_MESSAGE = "Пользователь не найден";
    private final UsersService userService;
    private final Map<String, String> refreshStorage = new HashMap<>();
    private final JwtProvider jwtProvider;

    private final AuthenticationManager authenticationManager;

    public JwtResponse login(@NonNull JwtRequest authRequest) {
        Authentication authentication;
        //todo переделать авторизацию
        /*
        get user from db
        check password using passwordEncoder.matches
        if not match - throw exception for 401 status code
        if match - generate token
         */
        try {
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(authRequest.getLogin(), authRequest.getPassword()));
            System.out.println(authentication);
        } catch (BadCredentialsException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Имя или пароль неправильны", e);
        }
        final Users user = userService.findByUserLogin(authRequest.getLogin())
                .orElseThrow(() -> new AuthException(EXCEPTION_MESSAGE));
        final String accessToken = jwtProvider.generateAccessToken(user);
        final String refreshToken = jwtProvider.generateRefreshToken(user);
        refreshStorage.put(user.getName(), refreshToken);
        return new JwtResponse(accessToken, refreshToken);
    }

    public JwtResponse getAccessToken(@NonNull String refreshToken) {
        if (!jwtProvider.validateRefreshToken(refreshToken)) {
            return new JwtResponse(null, null);
        }

        final Claims claims = jwtProvider.getRefreshClaims(refreshToken);
        final String login = claims.getSubject();
        System.out.println(login);
        final String saveRefreshToken = refreshStorage.get(login);

        if (saveRefreshToken == null || !saveRefreshToken.equals(refreshToken)) {
            return new JwtResponse(null, null);
        }

        final Users user = userService.findByUserLogin(login)
                .orElseThrow(() -> new AuthException(EXCEPTION_MESSAGE));
        final String accessToken = jwtProvider.generateAccessToken(user);

        return new JwtResponse(accessToken, null);
    }

    public JwtResponse refresh(@NonNull String refreshToken) {
        if (jwtProvider.validateRefreshToken(refreshToken)) {
            final Claims claims = jwtProvider.getRefreshClaims(refreshToken);
            final String login = claims.getSubject();
            final String saveRefreshToken = refreshStorage.get(login);
            if (saveRefreshToken != null && saveRefreshToken.equals(refreshToken)) {
                final Users user = userService.findByUserLogin(login)
                        .orElseThrow(() -> new AuthException(EXCEPTION_MESSAGE));
                final String accessToken = jwtProvider.generateAccessToken(user);
                final String newRefreshToken = jwtProvider.generateRefreshToken(user);
                refreshStorage.put(user.getName(), newRefreshToken);
                return new JwtResponse(accessToken, newRefreshToken);
            }
        }
        throw new AuthException("Невалидный JWT токен");
    }

    public JwtAuthentication getAuthInfo() {
        return (JwtAuthentication) SecurityContextHolder.getContext().getAuthentication();
    }
}
