package com.example.demo;

import com.example.demo.entities.User;
import com.example.demo.service.UserService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HelloController {

    private final UserService userService;


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

    @GetMapping("/persons")
    public List<User> getAllPersons() {
        return userService.getAllUsers();
    }
}
