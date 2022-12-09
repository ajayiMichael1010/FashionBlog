//package com.example.fashionblog.entities;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//@Entity
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//
//public class User11 extends BaseEntity {
//
//    @Column(nullable = false)
//    private String fullName;
//
//    private String email;
//
//    private String password;
//
////    @OneToMany(
////            mappedBy = "user"
////    )
////    @Cascade(org.hibernate.annotations.CascadeType.ALL)
////    @JsonManagedReference
////    private List<Post> postList=new ArrayList<>();
//
//
////    @ManyToOne
////    @JoinColumn(
////            name="role_id"
////    )
////
////    @JsonBackReference
////    private UserRole role;
//
////    @OneToMany(
////            mappedBy = "user",
////            cascade =CascadeType.ALL,
////            fetch = FetchType.LAZY,
////            orphanRemoval = true
////    )
////    @JsonManagedReference
////    private List<PostComment> postComments = new ArrayList<>();
//}
