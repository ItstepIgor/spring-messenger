package com.chatservice.service;

import com.chatservice.dto.MessageDto;
import com.chatservice.repository.MessagesRepository;
import com.chatservice.service.mapper.MessageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MessageService {

    private final MessagesRepository messagesRepository;

    private final MessageMapper messageMapper;



    @Transactional
    public void saveMessage(MessageDto messageDto) {
        messagesRepository.save(messageMapper.toModel(messageDto));
    }
}
