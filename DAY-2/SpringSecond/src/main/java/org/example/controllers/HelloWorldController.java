package org.example.controllers;

import org.example.models.Employee;
import org.example.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloWorldController {
    @Autowired
    private HelloWorldService hws;


    @GetMapping("/")
    public List<Employee> getMethod(){
        return hws.getMethod();
    }

//    @PostMapping("/")002

    public List<Employee> postMethod(@RequestBody Employee emp) {
        return hws.postMethod(emp);
    }

//    @PutMap ping("/{id}")
//    public List<Employee> putMethod(@PathVariable int id, @RequestBody Employee emp) {
//        return hws.putMethod(id, emp);
//    }

    @DeleteMapping("/{id}")
    public List<Employee> deleteById(@PathVariable int id) {
        return hws.deleteMethod(id);  // Write a method that removes employee by ID
    }


}
