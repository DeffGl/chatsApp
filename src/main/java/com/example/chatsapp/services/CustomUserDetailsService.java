package com.example.chatsapp.services;

import com.example.chatsapp.models.UserCredentials;
import com.example.chatsapp.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserCredentialsService userCredentialsService;

    @Autowired
    public CustomUserDetailsService(UserCredentialsService userDetailsService) {
        this.userCredentialsService = userDetailsService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserCredentials userCredentials = Optional.ofNullable(userCredentialsService.findCredentialsByLogin(username))
                .orElseThrow(()-> new UsernameNotFoundException("Пользователь не найден"));
        return new CustomUserDetails(userCredentials);
    }
}
