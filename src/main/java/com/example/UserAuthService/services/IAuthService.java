package com.example.UserAuthService.services;

import com.example.UserAuthService.models.Token;
import com.example.UserAuthService.models.User;
import org.springframework.data.util.Pair;

public interface IAuthService {

    public User signUp(String name,
                       String email,
                       String password,
                       String phoneNumber);

    public Token login(String email,
                       String password);

    }
