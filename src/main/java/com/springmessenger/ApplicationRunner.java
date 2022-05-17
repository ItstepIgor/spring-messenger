package com.springmessenger;

import com.springmessenger.config.ApplicationConfig;
import com.springmessenger.controller.InputController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class ApplicationRunner {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(ApplicationConfig.class)) {
            InputController inputController = context.getBean("inputController", InputController.class);
            inputController.selectAction();
        }
    }
}
