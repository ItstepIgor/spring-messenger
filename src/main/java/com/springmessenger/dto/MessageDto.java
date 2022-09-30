package com.springmessenger.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {

    private long id;
    private LocalDateTime dataCreateMessage;
    private String content;

    private ChatDto chatDto;
    //todo можно ли так делать в DTO сразу класс, если нет то как в маппере(mapstruct) найти по id класс
//    private long chatId;
    private long senderUserId;
}
