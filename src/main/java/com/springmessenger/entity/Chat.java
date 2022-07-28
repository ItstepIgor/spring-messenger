package com.springmessenger.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany( fetch = FetchType.LAZY, mappedBy = "chats")
    private List<Users> users;

    public Chat(long id, String chatName) {
        this.id = id;
        this.chatName = chatName;
        messages = new ArrayList<>();
        users = new ArrayList<>();
    }

    public Chat() {
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
        return "Chat{" +
                "id=" + id +
                ", chatName='" + chatName + '\'' +
                '}';
    }
}
