package com.chatservice.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:application.yml")
@ComponentScan(basePackages = "com.chatservice")
@Configuration
public class ChatConfig {

}
