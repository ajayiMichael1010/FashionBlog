package com.example.fashionblog.services;

import com.example.fashionblog.entities.BlogUser;
import com.example.fashionblog.pojos.commentDtos.CommentRequest;
import com.example.fashionblog.pojos.commentDtos.CommentResponse;
import com.example.fashionblog.pojos.commentDtos.CommentUpdateRequest;
import com.example.fashionblog.util.ApiResponse;

import java.util.List;

public interface CommentService {
    ApiResponse createComment(CommentRequest commentRequest);
    ApiResponse deleteComment(Long Id);
    ApiResponse editComment(Long Id, CommentUpdateRequest commentUpdateRequest);
    //BlogUser anonymousUser(CommentRequest commentRequest);
}
