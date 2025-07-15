package com.example.springbootfirst.Services;

import com.example.springbootfirst.models.User;
import com.example.springbootfirst.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean authenticate(String username, String password) {
        if (username == null || password == null) return false;
        User user = userRepository.findByUsernameAndPassword(username, password);
        return user != null;
    }
}
