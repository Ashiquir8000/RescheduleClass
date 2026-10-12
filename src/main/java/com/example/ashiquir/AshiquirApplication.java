package com.example.ashiquir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AshiquirApplication {

    public static void main(String[] args) {
        SpringApplication.run(AshiquirApplication.class, args);
    }

}
