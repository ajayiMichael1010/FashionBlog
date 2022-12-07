package com.example.fashionblog.controllers;

import com.example.fashionblog.pojos.postDtos.PostRequest;
import com.example.fashionblog.pojos.postDtos.PostResponse;
import com.example.fashionblog.pojos.postDtos.PostUpdateRequest;
import com.example.fashionblog.services.PostService;
import com.example.fashionblog.util.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Service
@AllArgsConstructor
@RequestMapping("/api/v1")
public class PostController {
    private final PostService postService;

    @PostMapping("/post/create")
    public ApiResponse createPost(@RequestBody  PostRequest postRequest){
        return postService.createPost( postRequest);
    }

    @GetMapping("/post/get-post-by-id/{Id}")
    public PostResponse getPostById(@PathVariable  Long Id){
       return postService.getPostById(Id);
    }

    @GetMapping("/post/get-all-post")
    public List<PostResponse> getAllPost(){
        return postService.getAllPost();
    }

    @PutMapping("/post/update-post{Id}")
    public ApiResponse updatePost(@PathVariable Long Id, PostUpdateRequest postUpdateRequest){
        return postService.updatePost(Id, postUpdateRequest);
    }

    @GetMapping("/post/delete/{Id}")
    public ApiResponse deletePost(@PathVariable Long Id){
        return postService.deletePost(Id);
    }
}
