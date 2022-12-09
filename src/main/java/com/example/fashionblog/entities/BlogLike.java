package com.example.fashionblog.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @ManyToOne
    @JoinColumn(
            name="post_id",
            referencedColumnName = "Id"
    )
    @JsonBackReference
    private  Post post;

    @ManyToOne
    @JoinColumn(
            name="comment_id",
            referencedColumnName ="Id"
    )
    @JsonBackReference
    private PostComment postComment;

    @ManyToOne
    @JoinColumn(
            name="user_id",
            referencedColumnName = "Id"
    )
    @JsonBackReference
    private  BlogUser user;

}
