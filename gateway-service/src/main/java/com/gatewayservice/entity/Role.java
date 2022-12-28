package com.gatewayservice.entity;

import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;

@RequiredArgsConstructor
public enum Role /*implements GrantedAuthority*/ {

    ADMIN("ADMIN"),
    USER("USER");

    //TODO Security вернуть
    private final String vale;

//    @Override
//    public String getAuthority() {
//        return vale;
//    }
}
