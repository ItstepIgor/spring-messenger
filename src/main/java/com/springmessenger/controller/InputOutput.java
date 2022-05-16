package com.springmessenger.controller;

import com.springmessenger.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;

@Controller
public class InputOutput {

    @Autowired
    private MessageController messageController;

    public void selectAction() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("""
                    Выберите действие:
                    1 - Вывести список сообщений
                    2 - Создать новое сообщение
                    3 - Отредактировать сообщение
                    4 - Удалить сообщение
                    """);
            int a = scanner.nextInt();
            switch (a) {
                case 1 -> {
                    List<Message> messages = messageController.getAll();
                    for (Message message : messages) {
                        System.out.println(message);
                    }
                }
                case 2 -> {

                }
                case 3 -> {

                }
                case 4 -> {

                }

            }
        }
    }
}
