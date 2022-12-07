package com.example.fashionblog.pojos.postDtos;

import com.example.fashionblog.entities.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@ToString
public class PostResponse {
    private Long Id;
    private String title;
    private String description;
    private User user;
}
