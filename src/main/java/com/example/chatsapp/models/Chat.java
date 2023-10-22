package com.example.chatsapp.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "chats")
@Data
public class Chat {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "chat_name", unique = true)
    private String chatName;

    @OneToMany(mappedBy = "chat")
    private List<Message> messageList;
}
