package com.authorizationservice.config;

import com.authorizationservice.entity.Users;
import com.authorizationservice.util.UserFeignClients;
import com.authorizationservice.util.UserRestTemplate;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final PasswordEncoder passwordEncoder;
    private final UserRestTemplate userRestTemplate;
    private final UserFeignClients userFeignClients;

    public CustomAuthenticationProvider(UserRestTemplate userRestTemplate, UserFeignClients userFeignClients) {
        this.userFeignClients = userFeignClients;
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.userRestTemplate = userRestTemplate;
    }
    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        String userName = authentication.getName();
        String password = authentication.getCredentials().toString();

//        Users users = userRestTemplate.getUser(userName).getBody();
        Users users = userFeignClients.findByUserLogin(userName).getBody();

        if (users == null) {
            throw new BadCredentialsException("Unknown user "+userName);
        }

        if (!passwordEncoder.matches(password, users.getPassword())) {
            throw new BadCredentialsException("Bad password");
        }
        UserDetails principal = User.builder()
                .username(users.getName())
                .password(users.getPassword())
                .roles(String.valueOf(users.getRole()))
                .build();
        return new UsernamePasswordAuthenticationToken(
                principal, password, principal.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
