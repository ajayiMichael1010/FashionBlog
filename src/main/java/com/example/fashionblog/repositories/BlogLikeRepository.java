package com.example.fashionblog.repositories;

import com.example.fashionblog.entities.BlogLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogLikeRepository extends JpaRepository<BlogLike,Long> {
}
