package com.authorizationservice.service;

import com.authorizationservice.entity.Users;
import com.authorizationservice.util.UserFeignClients;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthorizationService implements UserDetailsService {
    private final UserFeignClients userFeignClients;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Users users = userFeignClients.findByUserLogin(userName).getBody();
        if (users == null) {
            throw new UsernameNotFoundException("Пользователь " + userName + " не существует");
        }
        return User.builder()
                .username(users.getName())
                .password(users.getPassword())
                .roles(String.valueOf(users.getRole()))
                .build();

    }
}
