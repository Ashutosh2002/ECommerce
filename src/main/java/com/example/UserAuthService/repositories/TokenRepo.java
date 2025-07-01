package com.example.UserAuthService.repositories;

import com.example.UserAuthService.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface TokenRepo extends JpaRepository<Token,Long> {

    @Override
    Token save(Token token);

    Token findByValue(String value);

    void deleteByValue(String value);

//    select * from token where value = ?1 and expires_at > now()
    Optional<Token> findByValueAndExpiresAtAfter(String tokenValue, Date expiresAt);
}
