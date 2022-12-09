package com.example.fashionblog.pojos.postDtos;

import com.example.fashionblog.entities.PostCategory;
import com.example.fashionblog.entities.PostComment;
import com.example.fashionblog.entities.BlogUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class PostResponse {
    private Long Id;
    private String title;
    private String description;
    private Long userID;
    private Long postCategoryId;
    //private PostCategory postCategory;
    //private BlogUser user;
    private Long postCommentCount;
    private Long postLikeCount;

    private List<PostComment> postComments=new ArrayList<>();
}
