package com.example.fashionblog.util;

import org.springframework.stereotype.Service;

@Service
public class ResponseManager<T> {

    public ApiResponse success(T data){
        ApiResponse apiResponse = new ApiResponse<T>("Success",true,data);
        return  apiResponse;
    }

    public ApiResponse error(T data){
        ApiResponse apiResponse = new ApiResponse<T>("Error",false,data);
        return  apiResponse;
    }


}
