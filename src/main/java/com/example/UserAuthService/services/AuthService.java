package com.example.UserAuthService.services;

import com.example.UserAuthService.exceptions.PasswordMismatchException;
import com.example.UserAuthService.exceptions.UserAlreadyExistException;
import com.example.UserAuthService.exceptions.UserNotFoundException;
import com.example.UserAuthService.models.User;
import com.example.UserAuthService.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService implements IAuthService{

    @Autowired
    private UserRepo userRepo;

    public User signUp(String name,
                       String email,
                       String password,
                       String phoneNumber){

        Optional<User> userOptional = userRepo.findByEmailEquals(email);

        if (userOptional.isPresent()){
            throw new UserAlreadyExistException("Please try login directly!");
        }

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);
        user.setPhoneNumber(phoneNumber);
        return userRepo.save(user);

    }

    public Pair<User,String> login(String email, String password){
        Optional<User> userOptional = userRepo.findByEmailEquals(email);
        if (userOptional.isEmpty()){
            throw new UserNotFoundException("Please try signup first!");
        }

        String storedPassword = userOptional.get().getPassword();

        if (!password.equals(storedPassword)){
            throw new PasswordMismatchException("Please type correct password!");
        }

        return Pair.of(userOptional.get(), "");
    }

}
