package com.training.demo.controllers;
import com.training.demo.models.RegisterDetails;
import com.training.demo.models.UserDetailsDto;
import com.training.demo.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public String addNewUser(@RequestBody UserDetailsDto register){
        return authService.addNewEmployee(register);
    }

    @PostMapping("/login")
    public String Login(@RequestBody RegisterDetails login){
        return authService.loginUser(login);
    }

}