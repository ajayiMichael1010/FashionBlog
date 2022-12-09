package com.example.fashionblog.pojos.postDtos;

import com.example.fashionblog.entities.Post;
import com.example.fashionblog.entities.BlogUser;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class PostRequest {
    private String title;
    private String description;
    private Long postCategoryId;

    public static Post mapToPostEntity(PostRequest postRequest){
        Post post = new Post();
        post.setTitle(postRequest.getTitle());
        post.setDescription(postRequest.getDescription());
        return post;
    }

}
