package com.springmessenger;

import com.springmessenger.config.ApplicationConfig;
import com.springmessenger.controller.InputOutput;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationRunner {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(ApplicationConfig.class)) {
            InputOutput inputOutput = context.getBean("inputOutput", InputOutput.class);
            inputOutput.selectAction();
        }
    }
}
