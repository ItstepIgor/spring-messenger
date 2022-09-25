package com.springmessenger.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessageDto {

    private long id;
    private LocalDateTime dataCreateMessage;
    private String content;

    private ChatDto chatDto;
    //todo можно ли так делать в DTO сразу класс, если нет то как в маппере(mapstruct) найти по id класс
//    private long chatId;
    private long senderUserId;
}
