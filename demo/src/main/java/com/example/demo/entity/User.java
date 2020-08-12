package com.example.demo.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class User {
    @NotEmpty(message = "密码不能为空")
    @Length(min = 11,max = 11,message = "电话号码必须11位",groups = {GroupA.class})
    @Length(min = 12,max = 12,message = "电话号码必须12位",groups = {GroupB.class})
    private String phone;
    @NotEmpty(message = "密码不能为空")
    @Length(min = 6,max = 20,message = "密码必须为6-20位")
    private String password;
    @NotEmpty(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String email;

    public interface GroupA{}
    public interface GroupB{}
}
