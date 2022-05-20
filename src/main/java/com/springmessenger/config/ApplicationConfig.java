package com.springmessenger.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

@Configuration
@ComponentScan(basePackages = "com.springmessenger")
public class ApplicationConfig {


    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }


    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("translation");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public PrintStream printStream() {
        return new PrintStream(System.out, true, StandardCharsets.UTF_8);
    }
}
