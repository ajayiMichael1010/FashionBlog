package com.example.fashionblog.entities;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@ToString
//@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class,property="id")
public class Post extends BaseEntity {

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
   private BlogUser user;

    @OneToMany(
            mappedBy = "post",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @JsonManagedReference
    //@JsonIgnore
    private List<PostComment> postComments;

    @OneToMany(
            mappedBy = "post",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @JsonManagedReference
    private List<BlogLike> blogLikes = new ArrayList<>();

    @ManyToOne
    @JoinColumn(
            name= "category_id",
    referencedColumnName = "Id"
    )
    @JsonBackReference
    private PostCategory postCategory;
}


