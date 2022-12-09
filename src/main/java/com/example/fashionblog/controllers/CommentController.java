package com.example.fashionblog.controllers;

import com.example.fashionblog.pojos.commentDtos.CommentRequest;
import com.example.fashionblog.pojos.commentDtos.CommentUpdateRequest;
import com.example.fashionblog.services.CommentService;
import com.example.fashionblog.util.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@RestController
@AllArgsConstructor

@RequestMapping("/api/v1")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/comment/create")
    public ApiResponse createComment(@RequestBody CommentRequest commentRequest) {
        return commentService.createComment(commentRequest);
    }

    @DeleteMapping("/comment/delete/{Id}")
    public ApiResponse deleteComment(@PathVariable Long Id) {
        return commentService.deleteComment(Id);
    }

    @PutMapping("/comment/edit/{Id}")
    public ApiResponse editComment(@PathVariable Long Id, CommentUpdateRequest commentUpdateRequest) {
        return commentService.editComment(Id, commentUpdateRequest);
    }
}
