package com.example.fashionblog.pojos.commentDtos;

import com.example.fashionblog.entities.Post;
import com.example.fashionblog.entities.User;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CommentRequest {
    @NotNull(message ="PostComment field can't be null")
    private String comment;
    private Post post;
}
