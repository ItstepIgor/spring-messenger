package com.springmessenger.service;

import com.springmessenger.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UsersService usersService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersService.findByUserLogin(username);
        if (users == null) {
            throw new UsernameNotFoundException("Пользователь " + username + " не существует");
        }
        return User.builder()
                .username(users.getName())
                .password(users.getPassword())
                .roles(String.valueOf(users.getRole()))
                .build();
    }
}
