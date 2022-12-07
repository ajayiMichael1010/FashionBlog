package com.example.fashionblog.repositories;

import com.example.fashionblog.entities.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCategoryRepository extends JpaRepository<PostCategory,Long> {
}
