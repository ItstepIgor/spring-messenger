package com.springmessenger.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (id != message.id) return false;
        if (senderUserId != message.senderUserId) return false;
        if (!Objects.equals(dataCreateMessage, message.dataCreateMessage))
            return false;
        if (!Objects.equals(content, message.content)) return false;
        return Objects.equals(chat, message.chat);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (dataCreateMessage != null ? dataCreateMessage.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (chat != null ? chat.hashCode() : 0);
        result = 31 * result + (int) (senderUserId ^ (senderUserId >>> 32));
        return result;
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
