package com.example.fashionblog.pojos.userDtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString

    public class UserUpdateRequest {
        @NotNull(message = "Name field can't be empty")
        private String fullName;
        @NotNull(message = "Email field can't be empty")
        @Email(message = "Please enter a valid email address")
        private String email;
    }

