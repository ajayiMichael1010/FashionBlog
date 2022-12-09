package com.example.fashionblog.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class PostCategory extends BaseEntity{
    private String categoryName;

    @OneToMany(
    mappedBy = "postCategory",
    cascade = CascadeType.ALL,
    fetch= FetchType.LAZY
    )
    @JsonManagedReference
    private List<Post> postList= new ArrayList<>();
}
