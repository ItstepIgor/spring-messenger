package com.springmessenger.entity;

import java.time.LocalDateTime;

public class MessageEntity {


    private long id;
    private LocalDateTime dataCreateMessage;
    private String content;
    private long chatId;
    private long senderUserId;

    public MessageEntity(long id, LocalDateTime dataCreateMessage, String content, long chatId, long senderUserId) {
        this.id = id;
        this.dataCreateMessage = dataCreateMessage;
        this.content = content;
        this.chatId = chatId;
        this.senderUserId = senderUserId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "MessageEntity{" +
                "id=" + id +
                ", dataCreateMessage=" + dataCreateMessage +
                ", content='" + content + '\'' +
                ", chatId=" + chatId +
                ", senderUserId=" + senderUserId +
                '}';
    }
}
