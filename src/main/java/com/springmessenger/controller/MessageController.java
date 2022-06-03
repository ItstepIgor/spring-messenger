package com.springmessenger.controller;


import com.springmessenger.dto.MessageDto;
import com.springmessenger.service.MessageService;
import com.springmessenger.service.mapper.MessageListMapper;
import com.springmessenger.service.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MessageController {


    @Autowired
    private MessageService messageService;
    @Autowired
    MessageListMapper messageListMapper;

    @Autowired
    MessageMapper messageMapper;

    public void getAll() {
        List<MessageDto> messages = messageListMapper.toDTOList(messageService.getAll());
        messages.forEach(System.out::println);
    }

    public void getById(long id) {
        System.out.println(messageMapper.toDTO(messageService.getById(id)));
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
