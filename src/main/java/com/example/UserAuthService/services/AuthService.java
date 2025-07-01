package com.example.UserAuthService.services;

import com.example.UserAuthService.exceptions.InvalidTokenException;
import com.example.UserAuthService.exceptions.PasswordMismatchException;
import com.example.UserAuthService.exceptions.UserAlreadyExistException;
import com.example.UserAuthService.exceptions.UserNotFoundException;
import com.example.UserAuthService.models.Role;
import com.example.UserAuthService.models.Token;
import com.example.UserAuthService.models.User;
import com.example.UserAuthService.repositories.RoleRepo;
import com.example.UserAuthService.repositories.TokenRepo;
import com.example.UserAuthService.repositories.UserRepo;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuthService implements IAuthService{

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private TokenRepo tokenRepo;

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
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setName(name);
        user.setPhoneNumber(phoneNumber);

//        List<Role> roleList = new ArrayList<>();
//        Role role = new Role();
//        role.setName("intialUser");
//        roleList.add(role);
//        user.setRoles(roleList);

//        Optional<Role> roleOptional = roleRepo.findRoleByNameEquals("initialUser");
//        if(roleOptional.isEmpty()){
//            Role role = new Role();
//            role.setName("initialUser");
//            roleRepo.save(role);
//        }
//
//        Role initialRole = roleRepo.findRoleByNameEquals("initialUser").get();
//
//        List<Role> roleList = new ArrayList<>();
//        roleList.add(initialRole);
//        user.setRoles(roleList);


        return userRepo.save(user);

    }

    public Token login(String email, String password){
        Optional<User> userOptional = userRepo.findByEmailEquals(email);
        if (userOptional.isEmpty()){
            throw new UserNotFoundException("Please try signup first!");
        }

//        String storedPassword = userOptional.get().getPassword();


        if (!bCryptPasswordEncoder.matches(password,userOptional.get().getPassword())){
            throw new PasswordMismatchException("Please type correct password!");
        }

//        Create a token and store it in the tokens table.
        Token token = new Token();
        token.setUser(userOptional.get());
        token.setValue(RandomStringUtils.randomAlphanumeric(128));
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 30);
        Date dateAfter30Days = calendar.getTime();

        token.setExpiresAt(dateAfter30Days);
        return tokenRepo.save(token);
    }

    @Override
    public User validateToken(String tokenValue) {
         Optional<Token> tokenOptional = tokenRepo.findByValueAndExpiresAtAfter(tokenValue, new Date());

         if (tokenOptional.isEmpty()) {
//             Token is invalid or expired
             throw new InvalidTokenException("Token is invalid or expired!");
         }

         return tokenOptional.get().getUser();

    }

}
