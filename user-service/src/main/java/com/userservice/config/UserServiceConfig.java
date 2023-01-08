package com.userservice.config;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:application.yml")
@ComponentScan(basePackages = "com.userservice")
@EnableAspectJAutoProxy
@EnableTransactionManagement
@EnableWebSecurity
public class UserServiceConfig {


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .mvcMatcher("/api/users/**")
                .authorizeRequests()
                .mvcMatchers("/api/users/**")
                .access("hasAuthority('SCOPE_resource.read')")
                .and()
                .oauth2ResourceServer()
                .jwt();
        return http.build();
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        PasswordEncoder encoder = new BCryptPasswordEncoder();
//        return encoder;
//    }

}
