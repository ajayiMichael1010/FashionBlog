package com.example.fashionblog.pojos.userDtos;

import com.example.fashionblog.entities.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class UserSignUpRequest {
    @NotNull(message="Name field can't be empty")
    private String fullName;
    @NotNull(message="Email field can't be empty")
    @Email(message = "Please enter a valid email address")
    private String email;
    @NotNull(message = "Password field can't be empty")
    private  String password;

}
