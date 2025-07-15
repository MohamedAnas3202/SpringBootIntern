package com.example.springbootfirst.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {


    @GetMapping("/signin")
    public String loginPage() {
        return "signin";
    }

    @GetMapping("/")
    public String homePage() {
        return "home"; // create home.html
    }
}
