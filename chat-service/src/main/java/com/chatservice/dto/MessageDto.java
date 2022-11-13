package com.chatservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {

    private LocalDateTime dataCreateMessage;

    private String content;

    private long chatId;

    private long senderUserId;
}
