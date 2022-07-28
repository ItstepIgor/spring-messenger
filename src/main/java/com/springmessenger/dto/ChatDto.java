package com.springmessenger.dto;

public class ChatDto {
    private long id;

    private String chatName;

    public ChatDto(long id, String chatName) {
        this.id = id;
        this.chatName = chatName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    @Override
    public String toString() {
        return "ChatDto{" +
                "id=" + id +
                ", chatName='" + chatName + '\'' +
                '}';
    }
}
