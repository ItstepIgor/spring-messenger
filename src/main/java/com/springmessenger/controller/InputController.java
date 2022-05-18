package com.springmessenger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class InputController {

    @Autowired
    private MessageController messageController;
    @Autowired
    private Scanner scanner;

    public void selectAction() {
        System.out.println("""
                Выберите действие:
                1 - Вывести список сообщений
                2 - Создать новое сообщение
                3 - Отредактировать сообщение
                4 - Удалить сообщение
                """);
        int a = scanner.nextInt();
        switch (a) {
            case 1 -> messageController.getAll();
            case 2 -> {
                System.out.println("Введите имя");
                String name = scanner.next();
                System.out.println("Введите текст сообщения");
                String text = scanner.next();
                messageController.create(name, text);
            }
            case 3 -> {
                System.out.println("Выберите id сообщения для изменения");
                messageController.getAll();
                long id = scanner.nextInt();
                System.out.println("Введите новый текст сообщения");
                String text = scanner.next();
                messageController.update(id, text);
            }
            case 4 -> {
                System.out.println("Выберите id сообщения для удаления");
                messageController.getAll();
                long id = scanner.nextInt();
                messageController.delete(id);
            }
        }
    }
}
