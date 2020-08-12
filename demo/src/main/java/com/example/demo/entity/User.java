package com.example.demo.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.GroupSequence;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class User {
    @NotEmpty(message = "电话不能为空",groups = {First.class})
    @Length(min = 11,max = 11,message = "电话号码必须11位",groups = {Second.class})
    private String phone;
    @NotEmpty(message = "密码不能为空",groups = {First.class})
    @Length(min = 6,max = 20,message = "密码必须为6-20位",groups = {Second.class})
    private String password;
    @NotEmpty(message = "邮箱不能为空",groups = {First.class})
    @Email(message = "邮箱格式不正确",groups = {Second.class})
    private String email;

    public interface First{}
    public interface Second{}
    @GroupSequence({First.class,Second.class})
    public interface Group{}
}
