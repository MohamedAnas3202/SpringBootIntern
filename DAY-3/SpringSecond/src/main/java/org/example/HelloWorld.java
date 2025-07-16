package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController combines @Controller + @ResponseBody
@RestController
public class HelloWorld {

    // Maps HTTP GET requests to "/"
    @GetMapping("/h")
    public String hello() {
        System.out.println("Hello World!"); // Console log
        return "Hello folks, Welcome to Spring Boot session"; // Response body
    }
}
