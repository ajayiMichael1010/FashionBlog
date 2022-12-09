package com.example.fashionblog.pojos.postDtos;

import java.util.ArrayList;
import java.util.List;

import com.example.fashionblog.entities.Post;
import com.example.fashionblog.entities.PostCategory;
import com.example.fashionblog.entities.BlogUser;
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
    @NotNull(message ="Please enter a valid category Id")
    private Long postCategoryId;

    public static Post mapToPostEntity(PostUpdateRequest postUpdateRequest){

        Post post= new Post();
        post.setTitle(postUpdateRequest.getTitle());
        post.setDescription(postUpdateRequest.getDescription());

        return post;
    }




}


