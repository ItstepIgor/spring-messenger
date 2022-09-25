package com.springmessenger.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateMessageDto {
    private String content;
    private long chatId;
    private long senderUserId;
}
