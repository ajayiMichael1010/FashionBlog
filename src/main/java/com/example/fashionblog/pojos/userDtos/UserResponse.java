package com.example.fashionblog.pojos.userDtos;

import com.example.fashionblog.entities.UserRole;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class UserResponse {
    private Long Id;
    private String fullName;
    private String email;
    private  String password;
    private UserRole userRole;
}
