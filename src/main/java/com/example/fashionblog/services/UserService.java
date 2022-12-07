package com.example.fashionblog.services;

import com.example.fashionblog.pojos.userDtos.UserLoginRequest;
import com.example.fashionblog.pojos.userDtos.UserResponse;
import com.example.fashionblog.pojos.userDtos.UserSignUpRequest;
import com.example.fashionblog.pojos.userDtos.UserUpdateRequest;
import com.example.fashionblog.util.ApiResponse;

import java.util.List;

public interface UserService {
    ApiResponse signUp(UserSignUpRequest userSignUpRequest);

    ApiResponse login(UserLoginRequest userLoginRequest);

    List<UserResponse> getAllUsers();
    ApiResponse logout();
    UserResponse getUserProfile(Long Id);
    ApiResponse editProfile(Long userId, UserUpdateRequest request);
    ApiResponse deleteProfile(Long userId);
}

