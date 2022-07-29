package com.springmessenger.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "data_create_message")
    private LocalDateTime dataCreateMessage;
    @Column(nullable = false)
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_id", nullable = false)
    private Chat chat;
    @Column(name = "sender_user_id", nullable = false)
    private long senderUserId;

//    public Message(long id, LocalDateTime dataCreateMessage, String content, Chat chat, long senderUserId) {
//        this.id = id;
//        this.dataCreateMessage = dataCreateMessage;
//        this.content = content;
//        this.chat = chat;
//        this.senderUserId = senderUserId;
//    }

    public Message() {

    }

    public long getId() {
        return id;
    }

    public LocalDateTime getDataCreateMessage() {
        return dataCreateMessage;
    }

    public String getContent() {
        return content;
    }

    public Chat getChat() {
        return chat;
    }

    public long getSenderUserId() {
        return senderUserId;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", dataCreateMessage=" + dataCreateMessage +
                ", content='" + content + '\'' +
                ", chat=" + chat +
                ", senderUserId=" + senderUserId +
                '}';
    }

    public static Builder builder() {
        return new Message().new Builder();
    }

    public class Builder {

        public Builder setId(long id) {
            Message.this.id = id;
            return this;
        }

        public Builder setDataCreateMessage(LocalDateTime dataCreateMessage) {
            Message.this.dataCreateMessage = dataCreateMessage;
            return this;
        }

        public Builder setContent(String content) {
            Message.this.content = content;
            return this;
        }

        public Builder setChat(Chat chat) {
            Message.this.chat = chat;
            return this;
        }

        public Builder setSenderUserId(long senderUserId) {
            Message.this.senderUserId = senderUserId;
            return this;
        }

        public Message build() {
            return Message.this;
        }

    }

}
