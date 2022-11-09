package com.chatservice.service.consumer;

import com.chatservice.entity.Message;
import com.chatservice.service.ChatService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {
    private static final String ORDER_TOPIC = "${topic.name}";
    private static final String CONSOLE_MESSAGE = "consoleMessage";

    private final ObjectMapper objectMapper;

    private final ChatService chatService;

    @Autowired
    public Consumer(ObjectMapper objectMapper, ChatService chatService) {
        this.objectMapper = objectMapper;
        this.chatService = chatService;
    }

    @KafkaListener(topics = ORDER_TOPIC)
    public void consumeMessage(String messageString) throws JsonProcessingException {
        log.info("message consumed {}", messageString);

        Message message = objectMapper.readValue(messageString, Message.class);

        chatService.saveMessage(message);
    }


    @KafkaListener(topics = CONSOLE_MESSAGE)
    public void consumeMessageConsole(String message) {
        log.info("receive console message {}", message);
    }
}
