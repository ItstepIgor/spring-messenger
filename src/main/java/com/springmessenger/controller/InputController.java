package com.springmessenger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;

import java.io.PrintStream;
import java.util.Locale;
import java.util.Scanner;

@Controller
public class InputController {

    @Autowired
    private MessageController messageController;
    @Autowired
    private Scanner scanner;

    @Autowired
    private MessageSource messageSource;
    @Autowired
    private PrintStream printStream;

    public void selectAction() {
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

        printStream.println(messageSource.getMessage("select.action", null, locale));
        printStream.println("1 - " + messageSource.getMessage("select.list.message", null, locale));
        printStream.println("2 - " + messageSource.getMessage("create.message", null, locale));
        printStream.println("3 - " + messageSource.getMessage("edit.message", null, locale));
        printStream.println("4 - " + messageSource.getMessage("delete.message", null, locale));
        int select = scanner.nextInt();
        switch (select) {
            case 1 -> messageController.getAll();
            case 2 -> {
                printStream.println(messageSource.getMessage("enter.name", null, locale));
                String name = scanner.next();
                printStream.println(messageSource.getMessage("enter.text", null, locale));
                String text = scanner.next();
                messageController.create(name, text);
            }
            case 3 -> {
                printStream.println(messageSource.getMessage("select.id.message.edit", null, locale));
                System.out.println();
                messageController.getAll();
                long id = scanner.nextInt();
                printStream.println(messageSource.getMessage("enter.new.text", null, locale));
                String text = scanner.next();
                messageController.update(id, text);
            }
            case 4 -> {
                printStream.println(messageSource.getMessage("select.id.message.delete", null, locale));
                System.out.println();
                messageController.getAll();
                long id = scanner.nextInt();
                messageController.delete(id);
            }
        }
    }
}
