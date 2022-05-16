package com.springmessenger.controller;


import com.springmessenger.dto.MessageDto;
import com.springmessenger.entity.Message;
import com.springmessenger.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;

    public /*List<MessageDto>*/  List<Message>  getAll() {
        return messageService.getAll();
    }
}
