package com.example.UserAuthService.controllers;

import com.example.UserAuthService.dtos.LoginRequestDto;
import com.example.UserAuthService.dtos.SignUpRequestDto;
import com.example.UserAuthService.dtos.UserDto;
import com.example.UserAuthService.models.Token;
import com.example.UserAuthService.models.User;
import com.example.UserAuthService.services.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private IAuthService authService;

    @PostMapping("/signup")
    public UserDto signUp(@RequestBody SignUpRequestDto signUpRequestDto){
        User user = authService.signUp(signUpRequestDto.getName(),signUpRequestDto.getEmail(),signUpRequestDto.getPassword(),signUpRequestDto.getPhoneNumber());

        return from(user);

    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto loginRequestDto){
        Token token = authService.login(loginRequestDto.getEmail(), loginRequestDto.getPassword());
//        UserDto userDto = new UserDto();
//        userDto.setTokenValue(token.getValue());
//        userDto.setEmail(token.getUser().getEmail());
//        userDto.setRoles(token.getUser().getRoles());
        return new ResponseEntity<>(token.getValue(), HttpStatus.OK);
    }

    @GetMapping("/validate/{tokenValue}")
    public void validateToken(@PathVariable String tokenValue){

    }

    private UserDto from(User user){
        UserDto userDto = new UserDto();
        userDto.setName(user.getName());
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
