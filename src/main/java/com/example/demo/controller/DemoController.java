package com.example.demo.controller;

import com.example.demo.config.StudentConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private StudentConfig studentConfig;

    @GetMapping("/getStuConfig")
    public Object getStuConfig() {
        return studentConfig;
    }

    @Value("${student.address.detailName}")
    private String detailName;

    @Value("${student.address.port}")
    private String port;

    @GetMapping("/getDetailName")
    public String getDetailName() {
        return detailName + ";" + port;
    }
}
