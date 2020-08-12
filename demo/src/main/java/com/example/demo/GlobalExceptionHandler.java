package com.example.demo;

import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<String> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e)
    {
        ObjectError error = e.getBindingResult().getAllErrors().get(0);
        return new Result<>(ResultCode.FAILED,error.getDefaultMessage());
    }

    @ExceptionHandler(TestException.class)
    public Result<String> testExceptionHandler(TestException e)
    {
        return new Result<>(ResultCode.FAILED,e.getMsg());
    }
}
