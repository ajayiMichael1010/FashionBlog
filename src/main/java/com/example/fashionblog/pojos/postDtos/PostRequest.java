package com.example.fashionblog.pojos.postDtos;

import com.example.fashionblog.entities.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class PostRequest {
    private String title;
    private String description;
    private User user;
    //private PostCategory postCategory;

}
