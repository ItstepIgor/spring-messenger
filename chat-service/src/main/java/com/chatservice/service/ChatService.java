package com.chatservice.service;


import com.chatservice.entity.Chat;
import com.chatservice.repository.ChatRepository;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final ChatRepository chatRepository;



    public ChatService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    public Chat findById(Long id) {
        return chatRepository.findById(id).orElse(null);
    }
}
