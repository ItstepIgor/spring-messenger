package com.springmessenger;

import com.springmessenger.controller.InputController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationRunner implements CommandLineRunner {
    public final InputController inputController;

    public ApplicationRunner(InputController inputController) {
        this.inputController = inputController;
    }

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRunner.class, args);

//        try (var context = new AnnotationConfigApplicationContext(ApplicationConfig.class)) {
//            InputController inputController = context.getBean("inputController", InputController.class);
//            inputController.selectAction();
//        }
    }

    @Override
    public void run(String... args) throws Exception {
        inputController.selectAction();
    }
}
