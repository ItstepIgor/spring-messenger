package com.springmessenger.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"chats"})
@Builder
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String avatarId;
    @Column(nullable = false)
    private String role;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "chats_users", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "chat_id")},
            uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "chat_id"})})
    List<Chat> chats;
}
