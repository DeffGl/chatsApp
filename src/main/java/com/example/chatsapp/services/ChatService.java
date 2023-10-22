package com.example.chatsapp.services;

import com.example.chatsapp.dto.ChatDto;
import com.example.chatsapp.models.Chat;
import com.example.chatsapp.repositories.ChatRepository;
import com.example.chatsapp.util.ChatNotFoundException;
import com.example.chatsapp.util.ChatNotSaveException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatService {

    private final ChatRepository chatRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ChatService(ChatRepository chatRepository, ModelMapper modelMapper) {
        this.chatRepository = chatRepository;
        this.modelMapper = modelMapper;
    }

    public List<ChatDto> getAllChats() {
        return chatRepository.findAll().stream().map(chat -> modelMapper.map(chat, ChatDto.class)).toList();
    }

    public void createChat(Chat chat) throws ChatNotSaveException {
        if (existsByChatName(chat.getChatName())) {
            throw new ChatNotSaveException("Чат с таким именем уже существует!");
        }
        chatRepository.save(chat);
    }

    public ChatDto getChatDto(String name) throws ChatNotFoundException {
        return modelMapper.map(getChat(name), ChatDto.class);
    }

    public Chat getChat(String name) throws ChatNotFoundException {
        Optional<Chat> chat = chatRepository.findByChatName(name);
        return chat.orElseThrow(() -> new ChatNotFoundException("Чат с таким именем не найден!"));
    }

    public boolean existsByChatName(String chatName) {
        return chatRepository.existsByChatName(chatName);
    }
}
