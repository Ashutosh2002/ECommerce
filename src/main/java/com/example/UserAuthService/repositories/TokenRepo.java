package com.example.UserAuthService.repositories;

import com.example.UserAuthService.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepo extends JpaRepository<Token,Long> {

    @Override
    Token save(Token token);

    Token findByValue(String value);

    void deleteByValue(String value);
}
