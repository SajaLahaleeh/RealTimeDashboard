package com.example.firstImplementation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication(scanBasePackages = "com.example.firstImplementation")
@EnableScheduling
public class FirstApproachClass {
    public static void main(String[] args) {
        SpringApplication.run(FirstApproachClass.class, args);
    }
}