package com.example.fashionblog.services.ServiceImpl;

import com.example.fashionblog.Security.AccessControl;
import com.example.fashionblog.entities.UserRole;
import com.example.fashionblog.entities.User;
import com.example.fashionblog.pojos.userDtos.UserLoginRequest;
import com.example.fashionblog.pojos.userDtos.UserResponse;
import com.example.fashionblog.pojos.userDtos.UserSignUpRequest;
import com.example.fashionblog.pojos.userDtos.UserUpdateRequest;
import com.example.fashionblog.repositories.RoleRepository;
import com.example.fashionblog.repositories.UserRepository;
import com.example.fashionblog.services.UserService;
import com.example.fashionblog.util.ApiResponse;
import com.example.fashionblog.util.ResponseManager;
import jakarta.servlet.http.HttpSession;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private  final UserRepository userRepository;
    private  final RoleRepository roleRepository;
    private  final ResponseManager responseManager;
    private final ModelMapper modelMapper;
    private HttpSession session;
    private  final AccessControl accessControl;

    @Override
    public ApiResponse signUp(UserSignUpRequest userSignUpRequest) {
        User user= new User();
        UserRole role= roleRepository.findById(2L).get();//DEFAULT ROLEID FOR ALL USERS
        modelMapper.map(userSignUpRequest,user);
        user.setRole(role);
        userRepository.save(user);
        return responseManager.success("User registered");
    }

    @Override
    public ApiResponse login(UserLoginRequest userLoginDto) {
        String email=userLoginDto.getEmail();
        String password= userLoginDto.getPassword();

        User user=userRepository.findUserByEmailAndPassword(email, password).get();

        if(user.equals(null))
           return responseManager.error("User not logged in");
        session.setAttribute("userDto", modelMapper.map(user,UserResponse.class));
        return  responseManager.success("Login successful");
    }

    @Override
    public ApiResponse logout() {
        session.invalidate();
        return responseManager.success("User logged out successfully");
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<UserResponse> userResponseList= new ArrayList<>();

        if(accessControl.isAdmin()){
            List<User> userList= userRepository.findAll();
            if(!userList.isEmpty()){
                userList.forEach(userEntity->{
                    userResponseList.add(modelMapper.map(userEntity,UserResponse.class));
                });
            }
        }
        return userResponseList;
    }


    @Override
    public UserResponse getUserProfile(Long Id) {
        UserResponse userResponse= new UserResponse();
        if (accessControl.userFromSession()!=null) {
            User user = userRepository.findById(Id).get();
            modelMapper.map(user,userResponse);
        }
        return userResponse;
    }

    @Override
    public ApiResponse editProfile(Long userId, UserUpdateRequest request) {
        User user= userRepository.findById(userId).orElse(null);
        modelMapper.map(request,user);
        userRepository.save(user);
        return responseManager.success("User updated successfully");
    }

    @Override
    public ApiResponse deleteProfile(Long userId) {
        userRepository.deleteById(userId);
        return responseManager.success("User deleted");
    }

}
