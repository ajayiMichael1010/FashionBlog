package com.example.fashionblog.services.ServiceImpl;

import com.example.fashionblog.Security.AccessControl;
import com.example.fashionblog.entities.Post;
import com.example.fashionblog.entities.PostComment;
import com.example.fashionblog.entities.BlogUser;
import com.example.fashionblog.entities.UserRole;
import com.example.fashionblog.enums.Role;
import com.example.fashionblog.pojos.commentDtos.CommentRequest;
import com.example.fashionblog.pojos.commentDtos.CommentUpdateRequest;
import com.example.fashionblog.repositories.CommentRepository;
import com.example.fashionblog.repositories.PostRepository;
import com.example.fashionblog.repositories.UserRepository;
import com.example.fashionblog.services.CommentService;
import com.example.fashionblog.services.UserService;
import com.example.fashionblog.util.ApiResponse;
import com.example.fashionblog.util.ResponseManager;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.Comment;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private ModelMapper modelMapper;
    private final AccessControl accessControl;
    private final PostRepository postRepository;
    private final ResponseManager responseManager;
    private final UserRepository userRepository;

    @Override
    public ApiResponse createComment(CommentRequest commentRequest) {
        BlogUser user = new BlogUser();

        if (accessControl.userFromSession()!=null) {modelMapper.map(accessControl.userFromSession(), user);}
        else {user = anonymousUser(commentRequest);}

        Long postId = commentRequest.getPostId();
        Post post = postRepository.findById(postId).orElse(null);

        String newComment = commentRequest.getComment();

        PostComment postComment =
                PostComment.builder()
                        .comment(newComment)
                        .post(post).user(user)
                        .build();
        commentRepository.save(postComment);

        return responseManager.success("Comment Added");
    }

    @Override
    public ApiResponse deleteComment(Long Id) {
        if(accessControl.userFromSession()==null)
            return responseManager.error("Please login first");
            commentRepository.deleteById(Id);
        return responseManager.success("Deleted");
    }

    @Override
    public ApiResponse editComment(Long Id, CommentUpdateRequest commentUpdateRequest) {
        if (accessControl.userFromSession()==null)
            return responseManager.error("Please login first");
        PostComment postComment = commentRepository.findById(Id).orElse(null);
        modelMapper.map(commentUpdateRequest, postComment);

        return responseManager.success("Post updated");
    }


    private BlogUser anonymousUser(CommentRequest commentRequest){

        BlogUser user=new BlogUser();

        if(accessControl.userFromSession()!=null){

            Long anonymousUserId= commentRequest.getAnonymousUserId();

            if(anonymousUserId==null){
                user.setFullName(commentRequest.getAnonymousFullName());
                user.setEmail("user@anonymous.com");
                user.setPassword("nill");
            }
            else{user=userRepository.findById(anonymousUserId).get();}

            user.setRole(userRole());
            System.out.println(user);
            userRepository.save(user);
        }
        return user;
    }

    private UserRole userRole(){
        UserRole userRole=new UserRole();
        userRole.setRole(Role.Anonymous);
        userRole.setId(3l);
        return userRole;
    }
}
