package com.assignment.service;

import com.assignment.model.User;
import com.assignment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User loginUser(User user) {
        return userRepository.loginUser(user);
    }

    public boolean registerUser(User newUser) {
        return userRepository.registerUser(newUser);
    }
}
