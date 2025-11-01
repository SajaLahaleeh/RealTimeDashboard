package com.example.firstImplementation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication(scanBasePackages = "com.example.firstImplementation")
public class FirstApproachClass {
    public static void main(String[] args) {
        SpringApplication.run(FirstApproachClass.class, args);
    }
}