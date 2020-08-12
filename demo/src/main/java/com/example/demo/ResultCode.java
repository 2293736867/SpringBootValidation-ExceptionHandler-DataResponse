package com.example.demo;

import lombok.Getter;

@Getter
public enum ResultCode {
    SUCCESS("111","成功"),FAILED("222","失败");

    private final String code;
    private final String message;
    ResultCode(String code,String message)
    {
        this.code = code;
        this.message = message;
    }
}
