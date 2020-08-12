package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Result<T> {
    private String code;
    private String message;
    private T data;

    public Result(ResultCode resultCode,T data)
    {
        code = resultCode.getCode();
        message = resultCode.getMessage();
        this.data = data;
    }
}
