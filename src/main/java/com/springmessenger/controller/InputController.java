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
    @Autowired
    private OutputController outputController;

    public void selectAction() {
        outputController.showMessage("select.action", "", "");
        outputController.showMessage("select.list.message", "1 - ", "");
        outputController.showMessage("create.message", "2 - ", "");
        outputController.showMessage("edit.message", "3 - ", "");
        outputController.showMessage("select.id.message.show", "4 - ", "");
        outputController.showMessage("delete.message", "5 - ", "");
        outputController.showMessage("show.cache", "6 - ", "");
        outputController.showMessage("exit", "7 - ", "");
        int select = scanner.nextInt();
        switch (select) {
            case 1 -> {
                messageController.getAll();
                System.out.println();
                selectAction();
            }
            case 2 -> {
                outputController.showMessage("enter.name", "", "");
                String name = scanner.next();
                outputController.showMessage("enter.text", "", "");
                String text = scanner.next();
                messageController.create(name, text);
                selectAction();
            }
            case 3 -> {
                outputController.showMessage("select.id.message.edit", "", "");
                System.out.println();
                messageController.getAll();
                long id = scanner.nextInt();
                outputController.showMessage("enter.new.text", "", "");
                String text = scanner.next();
                messageController.update(id, text);
                selectAction();
            }
            case 4 -> {
                messageController.getAll();
                long id = scanner.nextInt();
                messageController.getById(id);
                selectAction();
            }
            case 5 -> {
                outputController.showMessage("select.id.message.delete", "", "");
                System.out.println();
                messageController.getAll();
                long id = scanner.nextInt();
                messageController.delete(id);
                selectAction();
            }
            case 6 -> {
                outputController.showCache();
                selectAction();
            }
        }
    }
}
