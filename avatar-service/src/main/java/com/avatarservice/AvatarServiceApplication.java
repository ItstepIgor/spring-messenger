package com.avatarservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AvatarServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AvatarServiceApplication.class, args);
    }

}
