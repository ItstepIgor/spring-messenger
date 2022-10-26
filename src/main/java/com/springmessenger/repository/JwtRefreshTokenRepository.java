package com.springmessenger.repository;

import com.springmessenger.entity.jwt.JwtRefreshToken;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JwtRefreshTokenRepository extends MongoRepository<JwtRefreshToken, String> {
    JwtRefreshToken findByName(String name);
}
