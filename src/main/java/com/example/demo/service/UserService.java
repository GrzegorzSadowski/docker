package com.example.demo.service;

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;



    public List<User> getAllUsers()  {
        return userRepository.findAll();
    }

}
