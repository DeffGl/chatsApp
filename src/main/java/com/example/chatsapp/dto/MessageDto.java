package com.example.chatsapp.dto;

import lombok.Data;

import java.util.Date;
@Data
public class MessageDto {

    private String text;
    private UserDto user;
    private ChatDto chat;
    private Date timestamp;

    public String getAuthorMessage(){
        return String.format("%s %s", this.user.getName(), this.user.getSurname());
    }
}
