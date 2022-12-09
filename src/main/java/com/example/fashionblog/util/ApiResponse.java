package com.example.fashionblog.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class ApiResponse<T>{
    private String message;
    private boolean status;
    private T data;
}
