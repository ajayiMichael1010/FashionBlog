package com.example.fashionblog.repositories;

import com.example.fashionblog.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
