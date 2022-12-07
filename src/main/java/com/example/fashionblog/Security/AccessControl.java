package com.example.fashionblog.Security;

import com.example.fashionblog.entities.Post;
import com.example.fashionblog.entities.UserRole;
import com.example.fashionblog.enums.Role;
import com.example.fashionblog.pojos.commentDtos.CommentResponse;
import com.example.fashionblog.pojos.userDtos.UserResponse;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Data
@Service

public class AccessControl {
    private HttpSession session;

    public UserResponse userFromSession(){
        UserResponse userResponse= null;
        if(!session.getAttribute("userDto").equals(null))
            userResponse= (UserResponse) session.getAttribute("userDto");
        return userResponse;
    }

    public  boolean isAdmin(){
        boolean isPrivileged=false;
        if(!userFromSession().equals(null)) {
            if (userFromSession().getUserRole().getRole().equals(Role.Admin))
                isPrivileged = true;
        }
        return  isPrivileged;
    }


    public boolean isCommentOwner(CommentResponse commentResponse) {
        return false;
    }

    public boolean isPostOwner(Post post) {
        return false;
    }

}
