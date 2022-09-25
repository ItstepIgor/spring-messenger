package com.springmessenger.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"chat"})
@NoArgsConstructor
@Builder
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

//todo компактный билдер

//    public static Builder builder() {
//        return new Message().new Builder();
//    }
//
//    public class Builder {
//
//        public Builder setId(long id) {
//            Message.this.id = id;
//            return this;
//        }
//
//        public Builder setDataCreateMessage(LocalDateTime dataCreateMessage) {
//            Message.this.dataCreateMessage = dataCreateMessage;
//            return this;
//        }
//
//        public Builder setContent(String content) {
//            Message.this.content = content;
//            return this;
//        }
//
//        public Builder setChat(Chat chat) {
//            Message.this.chat = chat;
//            return this;
//        }
//
//        public Builder setSenderUserId(long senderUserId) {
//            Message.this.senderUserId = senderUserId;
//            return this;
//        }
//
//        public Message build() {
//            return Message.this;
//        }
//
//    }

}
