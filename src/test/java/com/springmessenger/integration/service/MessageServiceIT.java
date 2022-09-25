package com.springmessenger.integration.service;


import com.springmessenger.ApplicationRunner;
import com.springmessenger.entity.Chat;
import com.springmessenger.entity.Message;
import com.springmessenger.service.MessageService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest(classes = ApplicationRunner.class)
public class MessageServiceIT {

    private static final Long MESSAGE_ID = 1L;
    @Autowired
    private MessageService messageService;

    @Test
    void findById() {

        Message actualResult = messageService.findById(MESSAGE_ID);

        Message expectedResult = Message.builder()
                .id(MESSAGE_ID)
                .dataCreateMessage(LocalDateTime.parse("2022-06-15T13:05:42.489841"))
                .content("eeeeeeeettttt")
                .chat(Chat.builder()
                        .id(1)
                        .chatName("Ivan-Semen")
                        .build())
                .senderUserId(1)
                .build();

        //todo что можно сравнивать и на что проверить  тест при запросе к базе данных по id
        //todo в данном случае пришлось исключить из сравнения Chat
        Assertions.assertEquals(expectedResult, actualResult);

    }
}
