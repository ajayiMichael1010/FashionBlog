package com.example.fashionblog.services.ServiceImpl;

import com.example.fashionblog.Security.AccessControl;
import com.example.fashionblog.entities.BlogLike;
import com.example.fashionblog.entities.Post;
import com.example.fashionblog.entities.PostComment;
import com.example.fashionblog.entities.BlogUser;
import com.example.fashionblog.pojos.BlogLikeDto;
import com.example.fashionblog.repositories.BlogLikeRepository;
import com.example.fashionblog.repositories.CommentRepository;
import com.example.fashionblog.repositories.PostRepository;
import com.example.fashionblog.services.BlogLikeService;
import com.example.fashionblog.util.ApiResponse;
import com.example.fashionblog.util.ResponseManager;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BlogLikeImpl implements BlogLikeService {
    private final BlogLikeRepository blogLikeRepository;
    private AccessControl accessControl;
    private ModelMapper modelMapper;
    private final ResponseManager responseManager;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Override
    public ApiResponse likeOrUnLikePost(BlogLikeDto blogLikeDto) {

        Long Id=blogLikeDto.getLikeId();
        Long commentId= blogLikeDto.getCommentId();
        Long postId= blogLikeDto.getPostId();

        BlogLike blogLike =new BlogLike();
        BlogUser user=new BlogUser();
        if(accessControl.userFromSession()!=null){

            modelMapper.map(accessControl.userFromSession(),user);
            Post post=getPost(postId);

            if(postOrCommentIsLikedAlready(Id)){blogLikeRepository.deleteById(Id);}
            else{
                if(commentId!=null){
                    PostComment postComment= getComment(commentId);
                    blogLike.setPostComment(postComment);
                }
                blogLike.setPost(post);
                //blogLike.setUser(user);
                blogLikeRepository.save(blogLike);
            }
        }
        return responseManager.success("Done");
    }

    private boolean postOrCommentIsLikedAlready(Long Id){
        BlogLike blogLike = blogLikeRepository.findById(Id).orElse(null);
        return blogLike==null?false:true;
    }

    private Post getPost(Long postId){
        Post post=postRepository.findById(postId).orElse(null);
        return post;
    }
    private PostComment getComment(Long commentId){
        PostComment postComment= commentRepository.findById(commentId).orElse(null);
        return postComment;
    }
}
