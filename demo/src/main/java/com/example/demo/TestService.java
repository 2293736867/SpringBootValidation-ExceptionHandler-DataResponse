package com.example.demo;

import com.example.demo.entity.User;
import org.springframework.http.codec.EncoderHttpMessageWriter;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
public class TestService {
    public Result<User> test(User user)
    {
//        持久化操作
        return new Result<>("111","success",user);
    }
}
