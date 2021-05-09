package com.southwind;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.southwind.mapper")
public class SprignbootShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(SprignbootShiroApplication.class, args);
    }

}
