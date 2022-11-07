package com.messageservice.controller;

import com.messageservice.dto.MessageDto;
import com.messageservice.service.MessageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageService messageService;


    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public void saveMessage(@RequestBody MessageDto MessageDto) {
        messageService.saveMessage(MessageDto);
    }
}
