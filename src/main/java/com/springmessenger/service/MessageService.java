package com.springmessenger.service;

import com.springmessenger.dto.CreateMessageDto;
import com.springmessenger.entity.Message;
import com.springmessenger.repository.MessageRepository;
import com.springmessenger.repository.MessagesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class MessageService {

    private final MessageRepository messageRepository;
    private final MessagesRepository messagesRepository;

    private final ChatService chatService;

    public MessageService(MessageRepository messageRepository, MessagesRepository messagesRepository, ChatService chatService) {
        this.messageRepository = messageRepository;
        this.messagesRepository = messagesRepository;
        this.chatService = chatService;
    }


    public List<Message> getAllMessage() {
//        return messageRepository.findAll();
        return messagesRepository.findAll();
    }

    public Message findById(long id) {
//        return messageRepository.findById(id);
        return messagesRepository.findById(id).orElse(null);
    }

    @Transactional
    public void saveMessage(CreateMessageDto createMessageDto) {
        Message message = Message.builder()
                .dataCreateMessage(LocalDateTime.now())
                .content(createMessageDto.getContent())
                .chat(chatService.findById(createMessageDto.getChatId()))
                .senderUserId(createMessageDto.getSenderUserId())
                .build();
        messagesRepository.save(message);
//        messageRepository.save(message);
    }

    @Transactional
    public void updateMessage(Message message) {
//        messageRepository.update(message);
        messagesRepository.save(message);
    }
    @Transactional
    public void deleteMessage(long id) {
        messagesRepository.deleteById(id);
    }
}
