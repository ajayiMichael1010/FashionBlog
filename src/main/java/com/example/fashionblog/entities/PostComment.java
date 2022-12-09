package com.example.fashionblog.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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

//@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class,property="id")
public class PostComment extends BaseEntity{
    private String comment;

    @ManyToOne
    @JoinColumn(
            name="post_id",
            referencedColumnName = "Id"
    )
    @JsonBackReference
    private  Post post;

    @ManyToOne
    @JoinColumn(
            name="user_id",
            referencedColumnName = "Id"
    )
    @JsonBackReference
    private  BlogUser user;

    @OneToMany(
            mappedBy = "postComment",
            cascade = CascadeType.ALL,
            fetch=FetchType.LAZY
    )
   @JsonManagedReference
    List<BlogLike> blogLikes = new ArrayList<>();
}
