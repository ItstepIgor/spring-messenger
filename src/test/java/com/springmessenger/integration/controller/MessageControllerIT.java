package com.springmessenger.integration.controller;

import com.springmessenger.ApplicationRunner;
import com.springmessenger.dto.CreateMessageDto;
import com.springmessenger.entity.Chat;
import com.springmessenger.entity.Message;
import com.springmessenger.service.MessageService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
//@WebMvcTest(MessageController.class)
//todo вместо @WebMvcTest вставил @SpringBootTest и @AutoConfigureMockMvc только так работает
// +  testImplementation 'junit:junit:4.13.1' в build.gradle
@SpringBootTest(classes = ApplicationRunner.class)
@AutoConfigureMockMvc
class MessageControllerIT {


    @Autowired
    private MockMvc mvc;

    @MockBean
    private MessageService messageService;


    @Test
    public void getAllMessage() throws Exception {
        Message message = Message.builder()
                .id(1L)
                .dataCreateMessage(LocalDateTime.parse("2022-06-15T13:05:42.489841"))
                .content("eeeeeeeettttt")
                .chat(Chat.builder()
                        .id(1)
                        .chatName("Ivan-Semen")
                        .build())
                .senderUserId(1)
                .build();

        List<Message> allMessage = Arrays.asList(message);

        given(messageService.getAllMessage()).willReturn(allMessage);

        mvc.perform(get("/api/messages")
                        .contentType(MediaType.APPLICATION_JSON))

                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].content", is(message.getContent())));
    }


    @Test
    public void saveMessageTest() throws Exception {
        CreateMessageDto createMessageDto = new CreateMessageDto("old message 3333", 2, 3);

        mvc.perform(post("/api/messages")
                        .param("dataCreateMessage", String.valueOf(LocalDateTime.now()))
                        .param("content", createMessageDto.getContent())
                        .param("chat", String.valueOf(Chat.builder()
                                .id(1)
                                .chatName("Ivan-Semen")
                                .build()))
                        .param("senderUserId", String.valueOf(createMessageDto.getSenderUserId())))
                .andExpect(status().isOk());

//                Message message = Message.builder()
//                        .dataCreateMessage(LocalDateTime.now())
//                        .content(createMessageDto.getContent())
//                        .chat(chatService.findById(createMessageDto.getChatId()))
//                        .senderUserId(createMessageDto.getSenderUserId())
//                        .build();

    }
}