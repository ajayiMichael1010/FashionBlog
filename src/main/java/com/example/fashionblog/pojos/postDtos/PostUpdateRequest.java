package com.example.fashionblog.pojos.postDtos;

import java.util.ArrayList;
import java.util.List;

import com.example.fashionblog.entities.PostCategory;
import com.example.fashionblog.entities.User;
import jakarta.validation.constraints.NotNull;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class PostUpdateRequest {
    @NotNull(message ="Title can't be empty")
    private String title;
    @NotNull(message ="Description can't be empty")
    private String description;
    private User user;
    private PostCategory postCategory;
}


