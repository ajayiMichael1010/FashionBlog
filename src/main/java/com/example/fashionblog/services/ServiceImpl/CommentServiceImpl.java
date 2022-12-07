//package com.example.fashionblog.services.ServiceImpl;
//
//import com.example.fashionblog.Security.AccessControl;
//import com.example.fashionblog.entities.Post;
//import com.example.fashionblog.entities.PostComment;
//import com.example.fashionblog.entities.User;
//import com.example.fashionblog.pojos.commentDtos.CommentRequest;
//import com.example.fashionblog.pojos.commentDtos.CommentUpdateRequest;
//import com.example.fashionblog.repositories.CommentRepository;
//import com.example.fashionblog.repositories.PostRepository;
//import com.example.fashionblog.services.CommentService;
//import com.example.fashionblog.util.ApiResponse;
//import com.example.fashionblog.util.ResponseManager;
//import lombok.AllArgsConstructor;
//import org.hibernate.annotations.Comment;
//import org.modelmapper.ModelMapper;
//import org.springframework.stereotype.Service;
//
//@Service
//@AllArgsConstructor
//public class CommentServiceImpl implements CommentService {
//    private final CommentRepository commentRepository;
//    private ModelMapper modelMapper;
//    private  final AccessControl accessControl;
//    private final PostRepository postRepository;
//    private final ResponseManager responseManager;
//
//    @Override
//    public ApiResponse createComment(CommentRequest commentRequest) {
//        if(!accessControl.userFromSession().equals(null)){
//            User user=new User();
//            modelMapper.map(accessControl.userFromSession(),user);
//
//            Long postId= commentRequest.getPost().getId();
//            Post post= postRepository.findById(postId).orElse(null);
//
//            String newComment=commentRequest.getComment();
//
//            PostComment postComment=
//                    PostComment.builder()
//                    .comment(newComment)
//                    .post(post).user(user)
//                    .build();
//            commentRepository.save(postComment);
//        }
//        return responseManager.success("Comment Added");
//    }
//
//    @Override
//    public ApiResponse deleteComment(Long Id) {
//        if(!accessControl.userFromSession().equals(null)){
//            commentRepository.deleteById(Id);
//        }
//        return responseManager.success("Deleted");
//    }
//
//    @Override
//    public ApiResponse editComment(Long Id, CommentUpdateRequest commentUpdateRequest) {
//        if(!accessControl.userFromSession().equals(null)){
//            PostComment postComment=commentRepository.findById(Id).orElse(null);
//            modelMapper.map(commentUpdateRequest,postComment);
//        }
//        return responseManager.success("Post updated");
//    }
//}
