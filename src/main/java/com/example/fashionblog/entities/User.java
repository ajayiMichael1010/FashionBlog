package com.example.fashionblog.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class User extends BaseEntity {

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany(
            mappedBy = "user"
    )
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Post> postList=new ArrayList<>();


    @ManyToOne
    @JoinColumn(
            name="role_id"
    )
    @JsonIgnore
    private UserRole role;

    @OneToMany(
            mappedBy = "user",
            cascade =CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private List<PostComment> postComments = new ArrayList<>();

}
