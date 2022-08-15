package com.springmessenger.controller;


import com.springmessenger.dto.CreateMessageDto;
import com.springmessenger.dto.MessageDto;
import com.springmessenger.service.MessageService;
import com.springmessenger.service.mapper.*;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MessageController {


    private final MessageService messageService;

    final
    MessageListMapper messageListMapper;

    final
    MessageMapper messageMapper;

    public MessageController(MessageService messageService, MessageListMapper messageListMapper, MessageMapper messageMapper) {
        this.messageService = messageService;
        this.messageListMapper = messageListMapper;
        this.messageMapper = messageMapper;
    }

    public void getAllMessage() {
        List<MessageDto> messages = messageListMapper.toDTOList(messageService.getAllMessage());
        messages.forEach(System.out::println);
    }

    public MessageDto getMessageById(long id) {
        return messageMapper.toDTO(messageService.findById(id));
    }

    public void saveMessage() {
        CreateMessageDto createMessageDto = new CreateMessageDto("new message", 2, 3);
        messageService.saveMessage(createMessageDto);
    }

    public void updateMessage(MessageDto messageDto) {
        messageService.updateMessage(messageMapper.toModel(messageDto));
    }

    public void deleteMessage(long id) {
        messageService.deleteMessage(id);
    }

}
