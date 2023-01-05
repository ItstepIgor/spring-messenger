package com.jwtserverservice.repository;

import com.jwtserverservice.entity.jwt.JwtRefreshToken;
//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JwtRefreshTokenRepository /*extends MongoRepository<JwtRefreshToken, String>*/ {
//    JwtRefreshToken findByName(String name);
}
