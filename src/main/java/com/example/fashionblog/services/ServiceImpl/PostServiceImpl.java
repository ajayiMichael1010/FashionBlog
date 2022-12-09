package com.example.fashionblog.services.ServiceImpl;

import com.example.fashionblog.Security.AccessControl;
import com.example.fashionblog.entities.Post;
import com.example.fashionblog.entities.PostCategory;
import com.example.fashionblog.entities.BlogUser;
import com.example.fashionblog.pojos.postDtos.PostRequest;
import com.example.fashionblog.pojos.postDtos.PostResponse;
import com.example.fashionblog.pojos.postDtos.PostUpdateRequest;
import com.example.fashionblog.repositories.PostCategoryRepository;
import com.example.fashionblog.repositories.PostRepository;
import com.example.fashionblog.repositories.UserRepository;
import com.example.fashionblog.services.PostService;
import com.example.fashionblog.util.ApiResponse;
import com.example.fashionblog.util.ResponseManager;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor

public class PostServiceImpl implements PostService {
    private  final UserRepository userRepository;
    private final ResponseManager responseManager;
    private final AccessControl accessControl;
    private final ModelMapper modelMapper;
    private final PostRepository postRepository;
    private final PostCategoryRepository postCategoryRepository;

    private HttpSession session;

    @Override
    public ApiResponse createPost(PostRequest postRequestDto) {

        if (accessControl.userFromSession()==null)
            return responseManager.error("Please login first");

        Post post = PostRequest.mapToPostEntity(postRequestDto);

        Long userId = accessControl.userFromSession().getId();
        Long postCategoryId = postRequestDto.getPostCategoryId();

        BlogUser user = userRepository.findById(userId).orElse(null);
        PostCategory postCategory = postCategoryRepository.findById(postCategoryId).orElse(null);

        post.setUser(user);
        post.setPostCategory(postCategory);
        postRepository.save(post);

        return responseManager.success("Post Created");

    }

    @Override
    public PostResponse getPostById(Long Id) {
        PostResponse postResponse= new PostResponse();
        Post post=postRepository.findById(Id).get();
        modelMapper.map(post, postResponse);
        postResponse.setPostCommentCount((long) post.getPostComments().size());
        postResponse.setPostLikeCount((long) post.getBlogLikes().size());

        return postResponse;
    }

    @Override
    public List<PostResponse> getAllPost() {

        List<PostResponse> postResponses= new ArrayList<>();

        postRepository.findAll()
        .forEach(post -> {
            PostResponse postResponse=new PostResponse();
            modelMapper.map(post,postResponse);
            postResponse.setPostCommentCount((long) post.getPostComments().size());
            postResponse.setPostLikeCount((long) post.getBlogLikes().size());
            postResponse.setPostComments(post.getPostComments());
            postResponses.add(postResponse);
        });

        return postResponses;
    }

    @Override
    public ApiResponse updatePost(Long Id, PostUpdateRequest postUpdateRequest) {

        PostCategory postCategory= postCategoryRepository.findById(postUpdateRequest.getPostCategoryId()).get();

        Post post= postRepository.findById(1L).orElse(null);

        modelMapper.map(postUpdateRequest,post);
        post.setPostCategory(postCategory);

        System.out.println(post);

        postRepository.save(post);

       return  responseManager.success("Post Updated Successfully");

    }

    @Override
    public ApiResponse deletePost(Long Id) {
        postRepository.deleteById(Id);
        return responseManager.success("Post deleted");
    }
}
