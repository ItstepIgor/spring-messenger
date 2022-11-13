package com.chatservice.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"messages"})
@ToString(exclude = {"users"})
@Builder
@Entity
@Table(name = "chats")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "chat_name", nullable = false)
    private String chatName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "chat")
    private List<Message> messages;
}
