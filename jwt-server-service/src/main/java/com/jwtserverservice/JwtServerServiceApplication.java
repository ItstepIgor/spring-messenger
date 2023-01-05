package com.jwtserverservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class JwtServerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtServerServiceApplication.class, args);
    }

}
