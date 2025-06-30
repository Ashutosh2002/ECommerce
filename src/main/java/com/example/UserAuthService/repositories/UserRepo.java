package com.example.UserAuthService.repositories;

import com.example.UserAuthService.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    Optional<User> findByEmailEquals(String email);

}
