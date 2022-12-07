package com.example.fashionblog.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PostCategory extends BaseEntity{
    private String categoryName;

//    @OneToMany(
//    mappedBy = "postCategory",
//    cascade = CascadeType.ALL,
//    fetch= FetchType.LAZY
//    )
//    private List<Post> postList= new ArrayList<>();
}
