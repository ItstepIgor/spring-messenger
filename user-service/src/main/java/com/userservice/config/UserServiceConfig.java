package com.userservice.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:application.yml")
@ComponentScan(basePackages = "com.userservice")
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class UserServiceConfig {

}
