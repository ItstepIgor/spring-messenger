package com.springmessenger.service;

import com.springmessenger.dto.CreateMessageDto;
import com.springmessenger.entity.Chat;
import com.springmessenger.entity.Message;
import com.springmessenger.repository.MessagesRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class MessageServiceTest {

    private static final Long MESSAGE_ID = 1L;
    @Mock
    private ChatService chatService;
    @Mock
    private MessagesRepository messageRepository;


    @InjectMocks
    private MessageService messageService;

    Message message = Message.builder().id(MESSAGE_ID).build();


    Message message2 = Message.builder().id(2).build();

    Chat chat = Chat.builder()
            .id(2)
            .chatName("Petr-Rich")
            .build();

    @Test
    void findById() {

//  todo    второй способ для мока не работает (разобраться если будет время)

//        Mockito.doReturn(Message.builder().setId(MESSAGE_ID).build()).when(messageRepository.findById(MESSAGE_ID));
        Mockito.when(messageRepository.findById(MESSAGE_ID)).thenReturn(Optional.ofNullable(message));
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
        Mockito.doNothing().when(messageRepository).delete(message);
        Mockito.when(messageRepository.findById(MESSAGE_ID)).thenReturn(Optional.ofNullable(message));
        messageService.deleteMessage(MESSAGE_ID);
        ArgumentCaptor<Message> argumentCaptor = ArgumentCaptor.forClass(Message.class);
        Mockito.verify(messageRepository).delete(argumentCaptor.capture());
        Assertions.assertEquals(message, argumentCaptor.getValue());
    }


    @Test
    void updateMessage() {
//        Mockito.doNothing().doThrow(new RuntimeException()).when(messageRepository).save(message);
        Mockito.when(messageRepository.save(message)).thenReturn(message);
        messageService.updateMessage(message);
        ArgumentCaptor<Message> argumentCaptor = ArgumentCaptor.forClass(Message.class);
        Mockito.verify(messageRepository).save(argumentCaptor.capture());
        Assertions.assertEquals(message, argumentCaptor.getValue());
    }


    @Test
    void saveMessage() {
        Mockito.when(chatService.findById(2L)).thenReturn(chat);
        Mockito.when(messageRepository.save(any())).thenReturn(message);
        CreateMessageDto createMessageDto = new CreateMessageDto("new message test", 2, 3);
        messageService.saveMessage(createMessageDto);
    }

    @Test
    void getAllMessage() {
        Mockito.when(messageRepository.findAll()).thenReturn(List.of(message, message2));

        List<Message> messages = messageService.getAllMessage();

        Assertions.assertEquals(2, messages.size());
    }

}