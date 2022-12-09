package com.example.fashionblog.services;

import com.example.fashionblog.pojos.BlogLikeDto;
import com.example.fashionblog.util.ApiResponse;

public interface BlogLikeService {
    ApiResponse likeOrUnLikePost(BlogLikeDto blogLikeDto);

}
