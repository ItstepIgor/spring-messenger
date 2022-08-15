package com.springmessenger.controller;

import com.springmessenger.service.MessageService;
import com.springmessenger.service.mapper.MessageCSVListMapper;
import com.springmessenger.service.mapper.MessageCSVMapper;
import org.springframework.stereotype.Controller;

@Controller
public class MessageCSVController {


    private final MessageService messageService;

    final
    MessageCSVListMapper messageCSVListMapper;

    final
    MessageCSVMapper messageCSVMapper;

    public MessageCSVController(MessageService messageService, MessageCSVListMapper messageCSVListMapper, MessageCSVMapper messageCSVMapper) {
        this.messageService = messageService;
        this.messageCSVListMapper = messageCSVListMapper;
        this.messageCSVMapper = messageCSVMapper;
    }

//    public void getAll() {
//        List<MessageCSVDto> messages = messageCSVListMapper.toDTOList(messageService.getAll());
//        messages.forEach(System.out::println);
//    }
//
//    public void getById(long id) {
//        System.out.println(messageCSVMapper.toDTO(messageService.getById(id)));
//    }
//
//    public void create(String name, String text) {
//        messageService.create(name, text);
//    }
//
//    public void delete(long id) {
//        messageService.delete(id);
//    }
//
//    public void update(long id, String text) {
//        messageService.update(id, text);
//    }
}
