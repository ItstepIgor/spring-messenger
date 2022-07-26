package com.springmessenger.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Chats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String chatName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "chats")
    private List<Message> messages;

//    @ManyToMany( fetch = FetchType.LAZY, mappedBy = "chats")
//    private List<Users> users;

    public Chats(long id, String chatName) {
        this.id = id;
        this.chatName = chatName;
        messages = new ArrayList<>();
//        users = new ArrayList<>();
    }

    public Chats() {
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
        return "Chats{" +
                "id=" + id +
                ", chatName='" + chatName + '\'' +
                '}';
    }
}
