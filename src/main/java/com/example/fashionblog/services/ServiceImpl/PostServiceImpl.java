package com.example.fashionblog.services.ServiceImpl;

import com.example.fashionblog.Security.AccessControl;
import com.example.fashionblog.entities.Post;
import com.example.fashionblog.entities.PostCategory;
import com.example.fashionblog.entities.User;
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
        if(!accessControl.userFromSession().equals(null)){
            Post post= new Post();
            Long  userId=accessControl.userFromSession().getId();

            User user = userRepository.findById(userId).orElse(null);
            //PostCategory postCategory= postCategoryRepository.findById(Id).orElse(null);

            modelMapper.map(postRequestDto, post);

            post.setUser(user);
            //post.setPostCategory(postCategory);

            postRepository.save(post);
        }
        return responseManager.success("Post Created");

    }

    @Override
    public PostResponse getPostById(Long Id) {
        //PostResponse postResponse= new PostResponse();
        Post post=postRepository.findById(1L).get();
        System.out.println(post);
      // modelMapper.map(post, postResponse);

        PostResponse postResponse=
                PostResponse.builder()
                        .title(post.getTitle()).description(post.getDescription()).user(post.getUser()).build();
        return postResponse;
    }

    @Override
    public List<PostResponse> getAllPost() {
        List<PostResponse> postResponses= new ArrayList<>();

        postRepository.findAll()
        .forEach(post -> {
            postResponses.add(modelMapper.map(post, PostResponse.class));
        });

        return postResponses;
    }

    @Override
    public ApiResponse updatePost(Long Id, PostUpdateRequest postUpdateRequest) {
        Post post= postRepository.findById(Id).orElse(null);
        modelMapper.map(postUpdateRequest,post);
        postRepository.save(post);
       return  responseManager.success("Post Updated Successfully");

    }

    @Override
    public ApiResponse deletePost(Long Id) {
        postRepository.deleteById(Id);
        return responseManager.success("Post deleted");
    }
}
