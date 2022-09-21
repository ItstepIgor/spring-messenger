package com.springmessenger.service;


import com.springmessenger.entity.Chat;
import com.springmessenger.repository.ChatRepository;
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
