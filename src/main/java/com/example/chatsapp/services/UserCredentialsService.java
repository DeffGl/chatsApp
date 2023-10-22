package com.example.chatsapp.services;

import com.example.chatsapp.models.User;
import com.example.chatsapp.models.UserCredentials;
import com.example.chatsapp.repositories.UserCredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCredentialsService {

    private final UserCredentialsRepository userCredentialsRepository;

    @Autowired
    public UserCredentialsService(UserCredentialsRepository userCredentialsRepository) {
        this.userCredentialsRepository = userCredentialsRepository;
    }

    public UserCredentials findCredentialsByLogin(String username) {
        return userCredentialsRepository.findByLogin(username);
    }

    public User findUserByLogin(String login) {
        return userCredentialsRepository.findByLogin(login).getUser();
    }
}
