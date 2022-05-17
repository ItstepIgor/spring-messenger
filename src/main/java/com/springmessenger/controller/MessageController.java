package com.springmessenger.controller;


import com.springmessenger.dto.MessageDto;
import com.springmessenger.entity.Message;
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

    public List<MessageDto> getAll() {
        return messageListMapper.toDTOList(messageService.getAll());
    }

    public MessageDto getById(long id) {
        return messageMapper.toDTO(messageService.getById(id));
    }

    public void create(String name, String text) {
        messageService.create(name, text);
    }
}
