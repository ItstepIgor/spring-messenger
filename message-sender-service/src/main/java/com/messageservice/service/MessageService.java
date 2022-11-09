package com.messageservice.service;

import com.messageservice.dto.MessageDto;
import com.messageservice.entity.Message;
import com.messageservice.service.producer.Producer;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MessageService {

    private final Producer producer;


    public MessageService(Producer producer) {
        this.producer = producer;
    }


    @SneakyThrows
    public String saveMessage(MessageDto messageDto) {
        Message message = Message.builder()
                .dataCreateMessage(LocalDateTime.now())
                .content(messageDto.getContent())
                .chatId(messageDto.getChatId())
                .senderUserId(messageDto.getSenderUserId())
                .build();
        return producer.sendMessage(message);
    }
}
