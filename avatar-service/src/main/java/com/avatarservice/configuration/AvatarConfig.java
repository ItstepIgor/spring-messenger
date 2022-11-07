package com.avatarservice.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@PropertySource("classpath:application.yml")
@ComponentScan(basePackages = "com.avatarservice")
@EnableTransactionManagement
public class AvatarConfig {


}
