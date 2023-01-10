package com.authorizationservice.util;

import com.authorizationservice.entity.Users;
import com.authorizationservice.entity.AuthRequest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-service")
public interface UserFeignClients {

    @PostMapping("/api/users/check")
    ResponseEntity<Users> checkUserLogin(@RequestBody AuthRequest authRequest);


    @PostMapping("/api/users/login")
    ResponseEntity<Users> findByUserLogin(@RequestBody String login);

}