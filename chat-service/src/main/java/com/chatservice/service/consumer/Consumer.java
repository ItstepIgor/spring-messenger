package com.chatservice.service.consumer;

import com.chatservice.dto.MessageDto;
import com.chatservice.service.MessageService;
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

    private final MessageService messageService;

    @Autowired
    public Consumer(ObjectMapper objectMapper, MessageService messageService) {
        this.objectMapper = objectMapper;
        this.messageService = messageService;
    }

    @KafkaListener(topics = ORDER_TOPIC)
    public void consumeMessage(String messageString) throws JsonProcessingException {
        log.info("message consumed {}", messageString);

        MessageDto messageDto = objectMapper.readValue(messageString, MessageDto.class);

        messageService.saveMessage(messageDto);
    }


    @KafkaListener(topics = CONSOLE_MESSAGE)
    public void consumeMessageConsole(String message) {
        log.info("receive console message {}", message);
    }
}
