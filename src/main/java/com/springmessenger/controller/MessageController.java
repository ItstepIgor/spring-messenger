package com.springmessenger.controller;


import com.springmessenger.dto.CreateMessageDto;
import com.springmessenger.dto.MessageDto;
import com.springmessenger.service.MessageService;
import com.springmessenger.service.mapper.MessageListMapper;
import com.springmessenger.service.mapper.MessageMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
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

    @GetMapping
    public void getAllMessage() {
        List<MessageDto> messages = messageListMapper.toDTOList(messageService.getAllMessage());
        messages.forEach(System.out::println);
    }

    @GetMapping("/{id}")
    public MessageDto getMessageById(@PathVariable("id") long id) {
        return messageMapper.toDTO(messageService.findById(id));
    }

    @PostMapping
    public void saveMessage(@RequestBody CreateMessageDto createMessageDto) {
        messageService.saveMessage(createMessageDto);
    }

    @PutMapping
    public void updateMessage(@RequestBody MessageDto messageDto) {
        messageService.updateMessage(messageMapper.toModel(messageDto));
    }

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable("id") long id) {
        messageService.deleteMessage(id);
    }
}
