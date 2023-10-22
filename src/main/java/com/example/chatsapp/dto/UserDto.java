package com.example.chatsapp.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDto {

    private String surname;
    private String name;
    private String patronymic;
    private Date dateOfBirth;
}
