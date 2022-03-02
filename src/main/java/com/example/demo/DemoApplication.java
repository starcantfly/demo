package com.example.demo;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
//        SpringApplication springApplication = new SpringApplication();
//        springApplication.setBannerMode(Banner.Mode.OFF);
        SpringApplication.run(DemoApplication.class, args);
    }

}
