//package com.example.fashionblog.services.ServiceImpl;
//
//import com.example.fashionblog.Security.AccessControl;
//import com.example.fashionblog.entities.BlogLike;
//import com.example.fashionblog.entities.Post;
//import com.example.fashionblog.entities.PostComment;
//import com.example.fashionblog.entities.User;
//import com.example.fashionblog.repositories.BlogLikeRepository;
//import com.example.fashionblog.repositories.CommentRepository;
//import com.example.fashionblog.repositories.PostRepository;
//import com.example.fashionblog.services.BlogLikeService;
//import com.example.fashionblog.util.ApiResponse;
//import com.example.fashionblog.util.ResponseManager;
//import lombok.AllArgsConstructor;
//import org.modelmapper.ModelMapper;
//import org.springframework.stereotype.Service;
//
//@Service
//@AllArgsConstructor
//public class BlogLikeImpl implements BlogLikeService {
//    private final BlogLikeRepository blogLikeRepository;
//    private AccessControl accessControl;
//    private ModelMapper modelMapper;
//    private final ResponseManager responseManager;
//    private final PostRepository postRepository;
//    private final CommentRepository commentRepository;
//
//    @Override
//    public ApiResponse likeOrUnLikePost(Long Id,String postType, Long postTypeId) {
//        BlogLike blogLike =new BlogLike();
//        User user=new User();
//        if(!accessControl.userFromSession().equals(null)){
//            modelMapper.map(accessControl.userFromSession(),user);
//
//            if(postOrCommentIsLikedAlready(Id)){
//                blogLikeRepository.deleteById(Id);
//            }
//            else{
//                Post post=getPost(postTypeId);
//                if(postType=="Comment"){
//                    PostComment postComment= getComment(postTypeId);
//                    blogLike
//                            .builder().post(post).postComment(postComment).user(user).build();
//                }else{
//                    blogLike.builder().post(post).user(user).build();
//                }
//                blogLikeRepository.save(blogLike);
//            }
//        }
//        return responseManager.success("Done");
//    }
//
//    private boolean postOrCommentIsLikedAlready(Long Id){
//        BlogLike blogLike = blogLikeRepository.findById(Id).orElse(null);
//        return !blogLike.equals(null)?true:false;
//    }
//
//    private Post getPost(Long postTypeId){
//        Post post=postRepository.findById(postTypeId).orElse(null);
//        return post;
//    }
//    private PostComment getComment(Long postTypeId){
//        PostComment postComment= commentRepository.findById(postTypeId).orElse(null);
//        return postComment;
//    }
//}
