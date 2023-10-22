package com.example.chatsapp.controllers;

import com.example.chatsapp.models.Chat;
import com.example.chatsapp.models.Message;
import com.example.chatsapp.services.ChatService;
import com.example.chatsapp.services.MessageService;
import com.example.chatsapp.util.ChatNotFoundException;
import com.example.chatsapp.util.ChatNotSaveException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ChatController {

    private final ChatService chatService;
    private final MessageService messageService;


    @Autowired
    public ChatController(ChatService chatService, MessageService messageService) {
        this.chatService = chatService;
        this.messageService = messageService;
    }

    @GetMapping("/chats")
    public String showChatList(Model model, HttpServletRequest request) {
        model.addAttribute("chats", chatService.getAllChats());
        if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
            return "table";
        } else {
            model.addAttribute("chats", chatService.getAllChats());
            return "chatList";
        }
    }

    @PostMapping("/chats")
    public ResponseEntity<Map<String, Object>> createChat(@RequestBody Chat chat) throws ChatNotSaveException {
        chatService.createChat(chat);
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.OK.value());
        response.put("message", "Чат успешно создан");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/chat/{chatName}")
    public String showChat(Model model, @PathVariable String chatName) throws ChatNotFoundException {
        model.addAttribute("chat", chatService.getChatDto(chatName));
        return "chat";
    }

    @PostMapping("/message")
    public ResponseEntity<Map<String, Object>> saveMessage(@RequestBody Message message, Authentication authentication) throws ChatNotFoundException {
        messageService.saveMessage(message, getUserLogin(authentication));
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.OK.value());
        response.put("message", "Чат успешно найден");
        return ResponseEntity.ok(response);
    }

    private String getUserLogin(Authentication authentication){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return userDetails.getUsername();
    }
}
