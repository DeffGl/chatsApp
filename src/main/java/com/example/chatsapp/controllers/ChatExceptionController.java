package com.example.chatsapp.controllers;

import com.example.chatsapp.util.ChatNotFoundException;
import com.example.chatsapp.util.ChatNotSaveException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@ControllerAdvice
public class ChatExceptionController {
    private static final Logger log = LoggerFactory.getLogger(ChatExceptionController.class);

    @ExceptionHandler
    public ResponseEntity<Map<String, Object>> handleChatNotSaveException(ChatNotSaveException ex){
        log.error(String.format("Произошла ошибка при создании чата: %s", ex.getMessage()));
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("message", Objects.requireNonNull(ex.getMessage()));
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler
    public ResponseEntity<Map<String, Object>> handleChatNotFoundException(ChatNotFoundException ex){
        log.error(String.format("Произошла ошибка при получении чата: %s", ex.getMessage()));
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("message", Objects.requireNonNull(ex.getMessage()));
        return ResponseEntity.badRequest().body(response);
    }
}
