package com.springmessenger.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

@Data
@AllArgsConstructor
@FieldNameConstants
public class CreateMessageDto {
    private String content;
    private long chatId;
    private long senderUserId;
}
