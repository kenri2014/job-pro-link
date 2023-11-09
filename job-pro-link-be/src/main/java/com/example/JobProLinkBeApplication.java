package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lantu.*.mapper")
public class JobProLinkBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobProLinkBeApplication.class, args);
    }

}
