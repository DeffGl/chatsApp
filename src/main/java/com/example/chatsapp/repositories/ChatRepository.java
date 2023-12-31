package com.example.chatsapp.repositories;

import com.example.chatsapp.models.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
    Optional<Chat> findByChatName(String name);
    boolean existsByChatName(String chatName);
}
