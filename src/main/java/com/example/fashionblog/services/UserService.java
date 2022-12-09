package com.example.fashionblog.services;

import com.example.fashionblog.entities.BlogUser;
import com.example.fashionblog.pojos.commentDtos.CommentRequest;
import com.example.fashionblog.pojos.userDtos.*;
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
    ApiResponse createUserRole(UserRoleRequest userRoleRequest);


}

