package com.jwtserverservice.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Id;

@Data
@Builder
public class JwtRefreshToken {
    @Id
    String id;
    String name;
    String token;
}
