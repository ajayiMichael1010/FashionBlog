package com.example.fashionblog.util;

import org.springframework.stereotype.Service;

@Service
public class ResponseManager<T> {

    public ApiResponse success(T data){
        ApiResponse apiResponse = new ApiResponse<T>("Success",200,data);
        return  apiResponse;
    }

    public ApiResponse error(T data){
        ApiResponse apiResponse = new ApiResponse<T>("Error",403,data);
        return  apiResponse;
    }


}
