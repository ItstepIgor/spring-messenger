package com.springmessenger;

import com.springmessenger.config.ApplicationConfig;
import com.springmessenger.controller.MessageController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationRunner {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(ApplicationConfig.class)) {
            MessageController messageController = context.getBean("messageController", MessageController.class);
            messageController.test();
        }
    }
}
