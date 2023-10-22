package com.example.chatsapp.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user_credentials")
@Data
public class UserCredentials {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "login", unique = true)
    private String login;

    @Column(name = "password")
    private String password;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
