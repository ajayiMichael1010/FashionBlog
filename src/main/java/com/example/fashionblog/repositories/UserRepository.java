package com.example.fashionblog.repositories;

import com.example.fashionblog.entities.BlogUser;
import com.example.fashionblog.pojos.userDtos.UserLoginRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<BlogUser,Long> {
    Optional<BlogUser> findUserByEmailAndPassword(String username, String password);
}
