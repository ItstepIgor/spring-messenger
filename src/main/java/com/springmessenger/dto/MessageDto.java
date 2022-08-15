package com.springmessenger.dto;

import java.time.LocalDateTime;

public class MessageDto {

    private long id;
    private LocalDateTime dataCreateMessage;
    private String content;

    private ChatDto chatDto;
    //todo можно ли так делать в DTO сразу класс, если нет то как в маппере(mapstruct) найти по id класс
//    private long chatId;
    private long senderUserId;

//    public MessageDto(long id, LocalDateTime dataCreateMessage, String content, long chatId, long senderUserId) {
//        this.id = id;
//        this.dataCreateMessage = dataCreateMessage;
//        this.content = content;
//        this.chatId = chatId;
//        this.senderUserId = senderUserId;
//    }

    public MessageDto(long id, LocalDateTime dataCreateMessage, String content, ChatDto chatDto, long senderUserId) {
        this.id = id;
        this.dataCreateMessage = dataCreateMessage;
        this.content = content;
        this.chatDto = chatDto;
        this.senderUserId = senderUserId;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getDataCreateMessage() {
        return dataCreateMessage;
    }

    public void setDataCreateMessage(LocalDateTime dataCreateMessage) {
        this.dataCreateMessage = dataCreateMessage;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ChatDto getChatDto() {
        return chatDto;
    }

    public void setChatDto(ChatDto chatDto) {
        this.chatDto = chatDto;
    }

//    public long getChatId() {
//        return chatId;
//    }
//
//    public void setChatId(long chatId) {
//        this.chatId = chatId;
//    }


    public long getSenderUserId() {
        return senderUserId;
    }

    public void setSenderUserId(long senderUserId) {
        this.senderUserId = senderUserId;
    }

    @Override
    public String toString() {
        return "MessageDto{" +
                "id=" + id +
                ", dataCreateMessage=" + dataCreateMessage +
                ", content='" + content + '\'' +
                ", chatDto=" + chatDto +
                ", senderUserId=" + senderUserId +
                '}';
    }
}
