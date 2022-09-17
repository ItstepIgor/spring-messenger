package com.springmessenger.service;

import com.springmessenger.entity.Message;
import com.springmessenger.repository.MessageRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MessageServiceTest {

    private static final Long MESSAGE_ID = 1L;
    @Mock
    private MessageRepository messageRepository;
    @Mock
    private ChatService chatService;
    @InjectMocks
    private MessageService messageService;

    @Test
    void findById() {
//        Mockito.doReturn(Message.builder()
//                        .setId(MESSAGE_ID)
//                        .build())
//                .when(messageRepository.findById(MESSAGE_ID));

        Mockito.when(messageRepository.findById(MESSAGE_ID)).thenReturn(Message.builder()
                .setId(MESSAGE_ID)
                .build());
        Message actualResult = messageService.findById(MESSAGE_ID);

        Message expectedResult = Message.builder()
                .setId(MESSAGE_ID)
                .build();

        Assertions.assertEquals(expectedResult, actualResult);
    }
}