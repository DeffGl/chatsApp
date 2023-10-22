package com.example.chatsapp.dto;

import lombok.Data;

import java.util.List;

@Data
public class ChatDto {
    private String chatName;
    private List<MessageDto> messageList;
}
