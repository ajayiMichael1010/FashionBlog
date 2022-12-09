package com.example.fashionblog.services.ServiceImpl;

import com.example.fashionblog.Security.AccessControl;
import com.example.fashionblog.entities.UserRole;
import com.example.fashionblog.entities.BlogUser;
import com.example.fashionblog.enums.Role;
import com.example.fashionblog.pojos.userDtos.*;
import com.example.fashionblog.repositories.RoleRepository;
import com.example.fashionblog.repositories.UserRepository;
import com.example.fashionblog.services.UserService;
import com.example.fashionblog.util.ApiResponse;
import com.example.fashionblog.util.ResponseManager;
import jakarta.servlet.http.HttpSession;
import lombok.*;
import org.modelmapper.ModelMapper;
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
    public ApiResponse<String> signUp(UserSignUpRequest userSignUpRequest) {
        BlogUser user= new BlogUser();
        UserRole role= roleRepository.findById(2L).get();//DEFAULT ROLEID FOR ALL CUSTOMERS
        modelMapper.map(userSignUpRequest,user);
        user.setRole(role);
        userRepository.save(user);
        return responseManager.success("BlogUser registered");
    }

    @Override
    public ApiResponse<String> login(UserLoginRequest userLoginDto) {
        String email=userLoginDto.getEmail();
        String password= userLoginDto.getPassword();
        BlogUser user=userRepository.findUserByEmailAndPassword(email, password).get();

        if(user==null)
           return responseManager.error("BlogUser not logged in");
        session.setAttribute("userDto", modelMapper.map(user,UserResponse.class));
        return  responseManager.success("Login successful");
    }

    @Override
    public ApiResponse<String> logout() {
        session.invalidate();
        return responseManager.success("BlogUser logged out successfully");
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<UserResponse> userResponseList= new ArrayList<>();

        if(accessControl.isAdmin()){
            List<BlogUser> userList= userRepository.findAll();
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
            BlogUser user = userRepository.findById(Id).get();
            modelMapper.map(user,userResponse);
        }
        return userResponse;
    }

    @Override
    public ApiResponse<String> editProfile(Long userId, UserUpdateRequest request) {
        BlogUser user= userRepository.findById(userId).orElse(null);
        modelMapper.map(request,user);
        userRepository.save(user);
        return responseManager.success("BlogUser updated successfully");
    }

    @Override
    public ApiResponse<String> deleteProfile(Long userId) {
        userRepository.deleteById(userId);
        return responseManager.success("BlogUser deleted");
    }

    @Override
    public ApiResponse createUserRole(UserRoleRequest userRoleRequest) {
        UserRole userRole= new UserRole();
        userRole.setRole(userRoleRequest.getRole());
        roleRepository.save(userRole);
        return  responseManager.success("User Role Added");
    }

}
