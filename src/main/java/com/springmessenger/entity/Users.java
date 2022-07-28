package com.springmessenger.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "chats_users", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "chat_id")},
            uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "chat_id"})})
    List<Chat> chats;

    public Users(long id, String name) {
        this.id = id;
        this.name = name;
        chats = new ArrayList<>();
    }

    public Users() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
