package com.springmessenger.config;

import com.springmessenger.controller.OutputController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Scanner;

@Configuration
@ComponentScan(basePackages = "com.springmessenger")
@EnableAspectJAutoProxy
public class ApplicationConfig {

    @Autowired
    private Scanner scanner;

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

    @Bean
    public OutputController OutputController() {
        Locale locale = null;
        System.out.println("""
                1 - English
                2 - Русский
                """);
        int selectLanguage = scanner.nextInt();
        switch (selectLanguage) {
            case 1 -> locale = new Locale("en", "EN");
            case 2 -> locale = new Locale("ru", "RU");
        }
        return new OutputController(locale);
    }
}
