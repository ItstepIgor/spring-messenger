package com.springmessenger.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private LocalDateTime dataCreateMessage;
    @Column(nullable = false)
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_id", nullable = false)
    private Chats chats;
    @Column(nullable = false)
    private long senderUserId;

    public Message(long id, LocalDateTime dataCreateMessage, String content, Chats chats, long senderUserId) {
        this.id = id;
        this.dataCreateMessage = dataCreateMessage;
        this.content = content;
//        this.chats = chats;
        this.senderUserId = senderUserId;
    }

    public Message() {

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

//    public Chats getChats() {
//        return chats;
//    }
//
//    public void setChatId(Chats chats) {
//        this.chats = chats;
//    }

    public long getSenderUserId() {
        return senderUserId;
    }

    public void setSenderUserId(long senderUserId) {
        this.senderUserId = senderUserId;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", dataCreateMessage=" + dataCreateMessage +
                ", content='" + content + '\'' +
//                ", chats=" + chats +
                ", senderUserId=" + senderUserId +
                '}';
    }
}
