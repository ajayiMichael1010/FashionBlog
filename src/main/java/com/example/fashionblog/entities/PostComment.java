package com.example.fashionblog.entities;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class PostComment extends BaseEntity{
    private String comment;

//    @ManyToOne
//    @JoinColumn(
//            name="post_id",
//            referencedColumnName = "Id"
//    )
//    private  Post post;

    @ManyToOne
    @JoinColumn(
            name="user_id",
            referencedColumnName = "Id"
    )
    private  User user;

    @OneToMany(
            mappedBy = "postComment",
            cascade = CascadeType.ALL
    )
    List<BlogLike> blogLikes = new ArrayList<>();

}
