package com.springmessenger.service;


import com.springmessenger.entity.Chat;
import com.springmessenger.repository.ChatRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChatService {

    private final ChatRepository chatRepository;

    public ChatService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }


    //todo поменять параметр в MessageService что бы принимался Optional
    public Optional<Chat> findById(Long id) {
        return chatRepository.findById(id);
    }
}
