package com.authorizationservice.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
@RequiredArgsConstructor
public class DefaultSecurityConfig {

    private final PasswordEncoder passwordEncoder;

//    @Bean
//    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests(authorizeRequests ->
//                        authorizeRequests
//                                .anyRequest()
//                                .authenticated()
//                )
//                .formLogin(withDefaults());
//        return http.build();
//    }

//    @Bean
//    UserDetailsService users() {
//        UserDetails user = User.builder()
//                .username("admin")
//                .password(passwordEncoder.encode("1"))
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user);
//    }


    private final CustomAuthenticationProvider authProvider;

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.authenticationProvider(authProvider);
        return authenticationManagerBuilder.build();
    }


//
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll();

        return http.build();
    }

//
////        http
////                .authorizeRequests(authorizeRequests ->
////                        authorizeRequests
////                                .anyRequest()
////                                .authenticated()
////                )
////                .formLogin();
////        return http.build();
////    }
//
////    @Bean
////    UserDetailsService users() {
////        UserDetails user = User.withDefaultPasswordEncoder()
////                .username("admin")
////                .password("1")
////                .roles("USER")
////                .build();
////        return new InMemoryUserDetailsManager(user);
////    }
}
