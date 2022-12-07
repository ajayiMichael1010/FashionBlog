package com.example.fashionblog.pojos.userDtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginRequest {
    @NotNull(message="Email can't be empty")
    @Email(message="Please enter a valid email")
    private String email;
    @NotNull (message="Password can't be empty")
    private String password;
}
