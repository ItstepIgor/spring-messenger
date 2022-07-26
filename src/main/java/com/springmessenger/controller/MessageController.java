package com.springmessenger.controller;


import com.springmessenger.dto.CreateMessageDto;
import com.springmessenger.dto.MessageDto;
import com.springmessenger.service.MessageService;
import com.springmessenger.service.mapper.*;
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

    @Autowired
    CreateMapperDto createMapperDto;

    public void getAllMessage() {
        messageService.getAllMessage();
        //        List<MessageDto> messages = messageListMapper.toDTOList(messageService.getAllMessage());
//        messages.forEach(System.out::println);
    }

//    public void createMessage() {
//        String str = "dsadasdasdsadas";
//        CreateMessageDto createMessageDto = new CreateMessageDto(str, 1, 3);
//        messageService.createMessage(createMapperDto.toModel(createMessageDto));
//    }

//    public void updateMessage(MessageDto messageDto) {
//        messageService.updateMessage(messageMapper.toModel(messageDto));
//    }
//
//    public MessageDto getMessageById(long id) {
//        return messageMapper.toDTO(messageService.getMessageById(id));
//    }

//    public void deleteMessage(long id) {
//        messageService.deleteMessage(id);
//    }

}
