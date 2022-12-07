package com.example.fashionblog.controllers;

import com.example.fashionblog.pojos.userDtos.UserLoginRequest;
import com.example.fashionblog.pojos.userDtos.UserResponse;
import com.example.fashionblog.pojos.userDtos.UserSignUpRequest;
import com.example.fashionblog.pojos.userDtos.UserUpdateRequest;
import com.example.fashionblog.services.UserService;
import com.example.fashionblog.util.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Service
@Data
@AllArgsConstructor
@RequestMapping("/api/v1")

public class UserController {
    private final UserService userService;

    @PostMapping("/sign-up")
    public ApiResponse signUp(@Valid @RequestBody UserSignUpRequest userSignUpRequest){
        return userService.signUp(userSignUpRequest);
    }

    @PostMapping("/login")
    public  ApiResponse login(@Valid @RequestBody UserLoginRequest userLoginRequest){
        return  userService.login(userLoginRequest);
    }
    @GetMapping("/logout")
    public  ApiResponse logout(){return userService.logout();}

    @GetMapping("/all-users")
    public List<UserResponse> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/my-profile/{id}")
    public UserResponse getUserProfile(@PathVariable Long id){return userService.getUserProfile(id);}

    @PutMapping("/user/edit/{id}")
    public ApiResponse editUser(@PathVariable Long id, @RequestBody  UserUpdateRequest userUpdateRequest){
        return userService.editProfile(id, userUpdateRequest);
    }

    @DeleteMapping("/user/delete/{id}")
    public ApiResponse deleteUser(@PathVariable Long id){
        return userService.deleteProfile(id);
    }
}
