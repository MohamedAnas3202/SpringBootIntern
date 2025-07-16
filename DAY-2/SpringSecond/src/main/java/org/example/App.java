package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// This annotation marks this as the main Spring Boot application
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        // Launches the Spring Boot application
        SpringApplication.run(App.class, args);
    }
}
