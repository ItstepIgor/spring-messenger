package com.springmessenger.service;

import com.springmessenger.dto.CreateMessageDto;
import com.springmessenger.entity.Message;
import com.springmessenger.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    private final ChatService chatService;

    public MessageService(MessageRepository messageRepository, ChatService chatService) {
        this.messageRepository = messageRepository;
        this.chatService = chatService;
    }

    public List<Message> getAllMessage() {
        return messageRepository.findAll();
    }

    public Message findById(long id) {
        return messageRepository.findById(id);
    }

    public void saveMessage(CreateMessageDto createMessageDto) {
        Message message = Message.builder()
                .setDataCreateMessage(LocalDateTime.now())
                .setContent(createMessageDto.getContent())
                .setChat(chatService.findById(createMessageDto.getChatId()))
                .setSenderUserId(createMessageDto.getSenderUserId())
                .build();
        messageRepository.save(message);
    }

    public void updateMessage(Message message) {
        messageRepository.update(message);
    }

    public void deleteMessage(long id) {
        messageRepository.delete(messageRepository.findById(id));
    }
}
