package com.springmessenger.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Scanner;

@Configuration
@PropertySource("classpath:application.yml")
@ComponentScan(basePackages = "com.springmessenger")
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class ApplicationConfig {


    @Bean
    public Scanner scanner() {
        return new Scanner(System.in).useDelimiter("\n");
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:translation");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DatabaseProperties databaseProperties() {
        return new DatabaseProperties();
    }
}
