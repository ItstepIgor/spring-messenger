package com.jwtserverservice.service;

import com.jwtserverservice.domain.JwtRefreshToken;
import com.jwtserverservice.repository.JwtRefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtRefreshTokenService {
    private final JwtRefreshTokenRepository jwtRefreshTokenRepository;

    public void save(JwtRefreshToken jwtRefreshToken) {
        JwtRefreshToken token = findByName(jwtRefreshToken.getName());
        if (token != null) {
            jwtRefreshTokenRepository.deleteById(token.getId());
        }
        jwtRefreshTokenRepository.insert(jwtRefreshToken);
    }

    public JwtRefreshToken findByName(String name) {
        return jwtRefreshTokenRepository.findByName(name);
    }
}
