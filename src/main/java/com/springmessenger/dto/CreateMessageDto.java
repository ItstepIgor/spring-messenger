package com.springmessenger.dto;

public class CreateMessageDto {
    private String content;
    private long chatId;
    private long senderUserId;

    public CreateMessageDto(String content, long chatId, long senderUserId) {
        this.content = content;
        this.chatId = chatId;
        this.senderUserId = senderUserId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    public long getSenderUserId() {
        return senderUserId;
    }

    public void setSenderUserId(long senderUserId) {
        this.senderUserId = senderUserId;
    }
}
