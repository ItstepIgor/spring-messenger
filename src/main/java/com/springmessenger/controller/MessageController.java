package com.springmessenger.controller;


import com.springmessenger.dto.MessageCSVDto;
import com.springmessenger.entity.Message;
import com.springmessenger.service.MessageService;
import com.springmessenger.service.mapper.MessageCSVListMapper;
import com.springmessenger.service.mapper.MessageCSVMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MessageController {


    @Autowired
    private MessageService messageService;
    @Autowired
    MessageCSVListMapper messageCSVListMapper;

    @Autowired
    MessageCSVMapper messageCSVMapper;


    public void getAllMessage() {
        List<Message> messages = messageService.getAllMessage();
        messages.forEach(System.out::println);
    }

//    public void create() {
//        MessageDBDto messageDBDto = new MessageDBDto();
//        messageService.create(messageDBDto);
//    }

    public void getAll() {
        List<MessageCSVDto> messages = messageCSVListMapper.toDTOList(messageService.getAll());
        messages.forEach(System.out::println);
    }

    public void getById(long id) {
        System.out.println(messageCSVMapper.toDTO(messageService.getById(id)));
    }

    public void create(String name, String text) {
        messageService.create(name, text);
    }

    public void delete(long id) {
        messageService.delete(id);
    }

    public void update(long id, String text) {
        messageService.update(id, text);
    }
}
