package com.example.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @description  返された結果の統一処理
 * @author ziqi
 * @since 2023-12-13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private String code;
    private String message;
    private T data;

    public static <T> Result<T> success(){
        return new Result<>(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(),null);
    }

    public static <T> Result<T> success(T data){
        return new Result<>(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(),data);
    }

    public static <T> Result<T> result(T data,StatusCode statusCode){
        return new Result<>(statusCode.getCode(),statusCode.getMessage(),data);
    }

    public static <T> Result<T> result(StatusCode statusCode){
        return new Result<>(statusCode.getCode(),statusCode.getMessage(),null);
    }
}



