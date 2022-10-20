package com.springmessenger.config;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @SneakyThrows
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll();

        return http.build();
    }
}
