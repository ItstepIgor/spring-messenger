package com.springmessenger.service;

import com.springmessenger.entity.jwt.JwtRefreshToken;
import com.springmessenger.repository.JwtRefreshTokenRepository;
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
