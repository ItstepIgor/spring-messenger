package com.springmessenger.controller;

import com.springmessenger.dto.MessageDto;
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
                    5 - Вывести одно сообщений
                    """);
            int a = scanner.nextInt();
            switch (a) {
                case 1 -> {
                    List<MessageDto> messages = messageController.getAll();
                    for (MessageDto message : messages) {
                        System.out.println(message);
                    }
                }
                case 2 -> {
                    System.out.println("Введите имя");
                    String name = scanner.next();
                    System.out.println("Введите текст сообщения");
                    String text = scanner.next();
                    messageController.create(name, text);
                }
                case 3 -> {

                }
                case 4 -> {

                }
                case 5 -> System.out.println(messageController.getById(2));
            }
        }
    }
}
