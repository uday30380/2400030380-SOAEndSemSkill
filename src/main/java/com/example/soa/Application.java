package com.example.soa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Author: Uday (2400030380)
// Subject: SOA End Semester Lab Project
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("SOA Spring Boot Application started successfully on port 8080!");
    }
}
