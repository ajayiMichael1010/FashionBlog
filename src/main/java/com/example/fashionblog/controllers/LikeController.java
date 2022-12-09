package com.example.fashionblog.controllers;

import com.example.fashionblog.pojos.BlogLikeDto;
import com.example.fashionblog.services.BlogLikeService;
import com.example.fashionblog.util.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@Service
@AllArgsConstructor
@RequestMapping("/api/v1")

public class LikeController {
    private BlogLikeService blogLikeService;

    @PostMapping("/like")
    public ApiResponse likeOrUnLikePost(@RequestBody BlogLikeDto blogLikeDto){
        return blogLikeService.likeOrUnLikePost(blogLikeDto);
    }
}
