package com.example.springbootfirst.controllers;

import com.example.springbootfirst.models.Employee;
import com.example.springbootfirst.models.Todo;
import com.example.springbootfirst.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String route() {
        return "Welcome to SpringBoot Security";
    }

    @GetMapping
    public List<Employee> getMethod() {
        return employeeService.getMethod();
    }

    @GetMapping("/{empID}")
    public Employee getEmployeeById(@PathVariable int empID) {
        return employeeService.getEmployeeById(empID);
    }

    @GetMapping("/job/{job}")
    public List<Employee> getEmployeeByJob(@PathVariable String job) {
        return employeeService.getEmployeeByJob(job);
    }

    @GetMapping("/role/{role}")
    public List<Employee> getEmployeeByRole(@PathVariable String role) {
        return employeeService.getEmployeesByRole(role);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public String postMethod(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    // New: Update employee by ID
    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        return employeeService.updateEmployeeById(id, employee);
    }

    @DeleteMapping("/{empID}")
    public String deleteMethod(@PathVariable int empID) {
        return employeeService.deleteEmployeeById(empID);
    }

    @PostMapping("/{id}/todos")
    public Todo addTodoToEmployee(@PathVariable int id, @RequestBody Todo todo) {
        return employeeService.addTodoToEmployee(id, todo);
    }

    @GetMapping("/{id}/todos")
    public List<Todo> getTodosForEmployee(@PathVariable int id) {
        return employeeService.getTodosForEmployee(id);
    }
}

