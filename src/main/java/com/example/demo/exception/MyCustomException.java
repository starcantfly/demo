package com.example.demo.exception;

/**
 * 自定义异常类
 */
public class MyCustomException extends RuntimeException {

    public MyCustomException(String errorMsg) {
        super(errorMsg);
    }
}
