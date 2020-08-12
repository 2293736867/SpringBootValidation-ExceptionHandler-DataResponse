package com.example.demo;

import com.example.demo.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class TestService {
    public String test(User user)
    {
        if(StringUtils.isEmpty(user.getEmail()))
            return "邮箱不能为空";
        if(StringUtils.isEmpty(user.getPassword()))
            return "密码不能为空";
        if(StringUtils.isEmpty(user.getPhone()))
            return "电话不能为空";
//        持久化操作
        return "success";
    }
}
