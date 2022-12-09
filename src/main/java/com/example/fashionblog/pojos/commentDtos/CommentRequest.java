package com.example.fashionblog.pojos.commentDtos;

import com.example.fashionblog.entities.Post;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CommentRequest {
    @NotNull(message ="PostComment field can't be null")
    private String comment;
    @NotNull(message ="Post Id can't be null")
    private Long postId;

    private Long anonymousUserId;
    private String anonymousFullName;
}
