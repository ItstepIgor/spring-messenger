package com.messageservice.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.time.LocalDateTime;

@Data
@Value
@Builder
public class Message {
    LocalDateTime dataCreateMessage;
    String content;
    long chatId;
    long senderUserId;
}
