package com.springmessenger.controller;

import com.springmessenger.dto.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class InputController {

    @Autowired
    private MessageController messageController;

    @Autowired
    private MessageCSVController messageCSVController;

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
                messageController.getAllMessage();


//                messageCSVController.getAll();
                System.out.println();
                selectAction();
            }
            case 2 -> {

//                messageController.createMessage();


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
//                messageCSVController.getAll();

//                messageController.getAllMessage();

                long id = scanner.nextInt();
//                MessageDto messageDto = messageController.getMessageById(id);

                outputController.showMessage("enter.new.text", "", "");
                String text = scanner.next();
//                messageCSVController.update(id, text);
//                messageDto.setContent(text);
//                messageController.updateMessage(messageDto);
                selectAction();
            }
            case 4 -> {
//                messageCSVController.getAll();
//                messageController.getAllMessage();
                long id = scanner.nextInt();
//                messageController.getMessageById(id);
//                messageCSVController.getById(id);
                selectAction();
            }
            case 5 -> {
                outputController.showMessage("select.id.message.delete", "", "");
                System.out.println();
//                messageCSVController.getAll();

//                messageController.getAllMessage();
                long id = scanner.nextInt();
//                messageController.deleteMessage(id);
//                messageCSVController.delete(id);
                selectAction();
            }
            case 6 -> {
                outputController.showCache();
                selectAction();
            }
        }
    }
}
