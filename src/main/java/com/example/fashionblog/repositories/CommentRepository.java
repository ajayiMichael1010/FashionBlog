package com.example.fashionblog.repositories;

import com.example.fashionblog.entities.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<PostComment,Long> {
}
