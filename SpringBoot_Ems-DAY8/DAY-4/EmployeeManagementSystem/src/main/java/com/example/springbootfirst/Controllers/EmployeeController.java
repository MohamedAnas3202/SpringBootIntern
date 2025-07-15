package com.example.springbootfirst.Controllers;

import com.example.springbootfirst.Services.EmployeeService;
import com.example.springbootfirst.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeService es;

    @GetMapping("/")
    public String home() {
        return "Spring Boot Employee API is running!";
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return es.getAllEmployees();
    }

    @GetMapping("/id/{empId}")
    public Employee getEmployeeById(@PathVariable int empId) {
        return es.getEmployeeById(empId);
    }

    @GetMapping("/name/{name}")
    public List<Employee> getEmployeeByName(@PathVariable String name) {
        return es.getEmployeeByName(name);
    }

    @GetMapping("/job/{job}")
    public List<Employee> getEmployeeByJob(@PathVariable String job) {
        return es.getEmployeeByJob(job);
    }

    @PostMapping
    public String createEmployee(@RequestBody Employee employee) {
        return es.createEmployee(employee);
    }

    @PutMapping("/{empId}")
    public String updateEmployee(@PathVariable int empId, @RequestBody Employee updatedEmployee) {
        return es.updateEmployee(empId, updatedEmployee);
    }

    @DeleteMapping("/id/{empId}")
    public String deleteEmployeeById(@PathVariable int empId) {
        return es.deleteEmployeeById(empId);
    }

    @DeleteMapping
    public String deleteAllEmployees() {
        return es.deleteAllEmployees();
    }
}
