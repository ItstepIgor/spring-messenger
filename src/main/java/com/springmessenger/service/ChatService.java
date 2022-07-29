package com.springmessenger.service;


import com.springmessenger.entity.Chat;
import com.springmessenger.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;

    public Chat findById(Long id) {
        return chatRepository.findById(id);
    }
}
