package com.example.demo.exception;

public class GraceException {

    public static void display(String errorMsg) {
        throw new MyCustomException(errorMsg);
    }
}
