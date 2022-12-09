package com.example.fashionblog.controllers;

import com.example.fashionblog.pojos.userDtos.*;
import com.example.fashionblog.services.UserService;
import com.example.fashionblog.util.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
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
        log.warn("This is a warning");
        log.info("This is an info");
        log.debug("A debug message");
        log.error("Mu error","It fails");

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

    @PostMapping("/user/role")
    public ApiResponse createUserRole(@RequestBody UserRoleRequest userRoleRequest){
        return userService.createUserRole(userRoleRequest);
    }
}
