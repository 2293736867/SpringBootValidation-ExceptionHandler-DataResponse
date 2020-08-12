package com.example.demo;

import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e)
    {
        ObjectError error = e.getBindingResult().getAllErrors().get(0);
        return error.getDefaultMessage();
    }

    @ExceptionHandler(TestException.class)
    public String testExceptionHandler(TestException e)
    {
        return e.getMsg();
    }
}
