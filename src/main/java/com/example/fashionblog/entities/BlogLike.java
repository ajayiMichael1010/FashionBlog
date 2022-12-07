package com.example.fashionblog.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class BlogLike extends BaseEntity{

//    @ManyToOne
//    @JoinColumn(
//            name="post_id",
//            referencedColumnName = "Id"
//    )
//    private  Post post;

    @ManyToOne
    @JoinColumn(
            name="comment_id",
            referencedColumnName ="Id"
    )
    private PostComment postComment;

    @ManyToOne
    @JoinColumn(
            name="user_id",
            referencedColumnName = "Id"
    )
    private  User user;

}
