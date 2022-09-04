package com.springmessenger.controller;

import com.springmessenger.dto.MessageDto;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class InputController {

    private final MessageController messageController;

    private final Scanner scanner;
    private final OutputController outputController;

    public InputController(MessageController messageController, Scanner scanner, OutputController outputController) {
        this.messageController = messageController;
        this.scanner = scanner;
        this.outputController = outputController;
    }

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
                messageController.getAllMessage();
                System.out.println();
                selectAction();
            }
            case 2 -> {

                messageController.saveMessage();

//                outputController.showMessage("enter.name", "", "");
//                String name = scanner.next();
//                outputController.showMessage("enter.text", "", "");
//                String text = scanner.next();
//                messageCSVController.create(name, text);
                selectAction();
            }
            case 3 -> {
                outputController.showMessage("select.id.message.edit", "", "");
                System.out.println();
                messageController.getAllMessage();
                long id = scanner.nextInt();
                MessageDto messageDto = messageController.getMessageById(id);
                System.out.println(messageDto);
                outputController.showMessage("enter.new.text", "", "");
                String text = scanner.next();
                System.out.println(text);
                messageDto.setContent(text);
                messageController.updateMessage(messageDto);
                selectAction();
            }
            case 4 -> {
                messageController.getAllMessage();
                long id = scanner.nextInt();
                messageController.getMessageById(id);
                selectAction();
            }
            case 5 -> {
                outputController.showMessage("select.id.message.delete", "", "");
                System.out.println();
                messageController.getAllMessage();
                long id = scanner.nextInt();
                messageController.deleteMessage(id);
                selectAction();
            }
            case 6 -> {
                outputController.showCache();
                selectAction();
            }
            default -> System.exit(0);
        }
    }
}
