package com.example.fashionblog.services;

import com.example.fashionblog.entities.Post;
import com.example.fashionblog.pojos.postDtos.PostRequest;
import com.example.fashionblog.pojos.postDtos.PostResponse;
import com.example.fashionblog.pojos.postDtos.PostUpdateRequest;
import com.example.fashionblog.util.ApiResponse;
import java.util.List;

public interface PostService {
    ApiResponse createPost(PostRequest postRequestDto);
    PostResponse getPostById(Long Id);
    List<PostResponse> getAllPost();
    ApiResponse updatePost(Long Id, PostUpdateRequest postUpdateRequest);
    ApiResponse deletePost(Long Id);


}
