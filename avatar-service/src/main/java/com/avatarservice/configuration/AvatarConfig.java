package com.avatarservice.configuration;

import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@PropertySource("classpath:application.yml")
@ComponentScan(basePackages = "com.avatarservice")
@EnableTransactionManagement
@EnableWebSecurity
public class AvatarConfig {

    @Bean
    @SneakyThrows
    SecurityFilterChain securityFilterChain(HttpSecurity http){
        http
                .mvcMatcher("/api/avatars/**")
                .authorizeRequests()
                .mvcMatchers("/api/avatars/**")
                .access("hasAuthority('SCOPE_resource.read')")
                .and()
                .oauth2ResourceServer()
                .jwt();
        return http.build();
    }


}
