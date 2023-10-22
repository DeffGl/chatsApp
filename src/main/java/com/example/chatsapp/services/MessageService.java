package com.example.chatsapp.services;

import com.example.chatsapp.models.Chat;
import com.example.chatsapp.models.Message;
import com.example.chatsapp.models.User;
import com.example.chatsapp.repositories.MessageRepository;
import com.example.chatsapp.util.ChatNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final UserCredentialsService userCredentialsService;
    private final ChatService chatService;

    @Autowired
    public MessageService(MessageRepository messageRepository, UserCredentialsService userCredentialsService, ChatService chatService) {
        this.messageRepository = messageRepository;
        this.userCredentialsService = userCredentialsService;
        this.chatService = chatService;
    }

    public void saveMessage(Message message, String login) throws ChatNotFoundException {
        Chat chat = chatService.getChat(message.getChat().getChatName());
        message
                .setUser(new User().setId(userCredentialsService
                        .findUserByLogin(login)
                        .getId()))
                .setChat(chat)
                .setTimestamp(new Date());
        messageRepository.save(message);
    }
}
