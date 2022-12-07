//package com.example.fashionblog.controllers;
//
//import com.example.fashionblog.services.BlogLikeService;
//import com.example.fashionblog.util.ApiResponse;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@Service
//@AllArgsConstructor
//@RequestMapping("/api/v1")
//
//public class LikeController {
//    private BlogLikeService blogLikeService;
//
//    @GetMapping("/like/{likeId}/{postType}/{postTypeId}")
//    public ApiResponse likeOrUnLikePost(@PathVariable("likeId") Long Id, @PathVariable String postType, @PathVariable Long postTypeId){
//        return blogLikeService.likeOrUnLikePost(Id,postType,postTypeId);
//    }
//}
