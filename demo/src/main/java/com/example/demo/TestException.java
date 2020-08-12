package com.example.demo;

import lombok.Data;

@Data
public class TestException extends RuntimeException{
    private int code;
    private String msg;

    public TestException(int code,String msg)
    {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public TestException()
    {
        this(111,"测试异常");
    }

    public TestException(String msg)
    {
        this(111,msg);
    }

}
