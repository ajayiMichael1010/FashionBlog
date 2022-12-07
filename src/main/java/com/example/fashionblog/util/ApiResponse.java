package com.example.fashionblog.util;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ApiResponse<T>{
    private String message;
    private Boolean status;
    private T data;

    public Boolean isSuccess(){
        return this.status;
    }
}
