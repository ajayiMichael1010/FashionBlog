package com.example.fashionblog.repositories;

import com.example.fashionblog.entities.User;
import com.example.fashionblog.pojos.userDtos.UserLoginRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findUserByEmailAndPassword(String username, String password);
}
