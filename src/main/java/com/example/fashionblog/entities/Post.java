package com.example.fashionblog.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import lombok.*;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@ToString

public class Post extends BaseEntity {

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

//    @OneToMany(
//            mappedBy = "post",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true,
//            fetch = FetchType.LAZY
//    )
//    private List<PostComment> postComments = new ArrayList<>();
//
//    @OneToMany(
//            mappedBy = "post",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true,
//            fetch = FetchType.LAZY
//    )
//    private List<BlogLike> blogLikes = new ArrayList<>();

//    @ManyToOne
//    @JoinColumn(
//            name= "category_id",
//    referencedColumnName = "Id"
//    )
//    private PostCategory postCategory;
}


