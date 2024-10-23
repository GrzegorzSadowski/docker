package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }

    @GetMapping("/greet")
    public String greet() {
        return "Greetings from the Spring Boot application!";
    }

    @GetMapping("/status")
    public String status() {
        return "Application is running!";
    }

    @GetMapping("/devops")
    public String getDevOpsValue() {
        String devOpsValue = System.getenv("DEVOPS");
        return "The value of DEVOPS is: " + (devOpsValue != null ? devOpsValue : "not set");
    }

}
