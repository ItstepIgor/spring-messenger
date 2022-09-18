package com.springmessenger.service;

import com.springmessenger.entity.Message;
import com.springmessenger.repository.MessageRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
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

    Message message = Message.builder().setId(MESSAGE_ID).build();

    @Test
    void findById() {

//      второй способ для мока не работает (разобраться если будет время)
//        Mockito.doReturn(Message.builder().setId(MESSAGE_ID).build()).when(messageRepository.findById(MESSAGE_ID));
        Mockito.when(messageRepository.findById(MESSAGE_ID)).thenReturn(message);
        Message actualResult = messageService.findById(MESSAGE_ID);

        Message expectedResult = message;
        ArgumentCaptor<Long> argumentCaptor = ArgumentCaptor.forClass(Long.class);
        Mockito.verify(messageRepository).findById(argumentCaptor.capture());
        //Сравниваем результат из метода
        Assertions.assertEquals(expectedResult, actualResult);
        //Сравниваем значение аргумента пришедшеее в метод с отправленным
        Assertions.assertEquals(MESSAGE_ID, argumentCaptor.getValue());
    }

    @Test
    void deleteMessage() {
        Mockito.doReturn(true).when(messageRepository.delete(message));
//        Mockito.when(messageRepository.delete(message))
//                .thenReturn(true)
//                .thenReturn(false);
    }

    @Test
    void getAllMessage() {
    }

    @Test
    void saveMessage() {
    }

    @Test
    void updateMessage() {
    }


}