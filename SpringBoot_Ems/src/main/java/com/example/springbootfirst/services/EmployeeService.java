package com.example.springbootfirst.services;

import com.example.springbootfirst.models.Employee;
import com.example.springbootfirst.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository empRepo;

    public List<Employee> getMethod() {
        return empRepo.findAll();
    }

    public Employee getEmployeeById(int empID) {
        return empRepo.findById(empID).orElse(new Employee());
    }


    public List<Employee> getEmployeeByJob(String job) {
        return empRepo.findByJob(job);
    }

    public String addEmployee(Employee employee) {
        empRepo.save(employee);
        return "Employee Added Successfully!!!";
    }

    public String updateEmployee(Employee employee) {
        empRepo.save(employee);
        return "Employee Updated Successfully!!!";
    }

    public String deleteEmployeeById(int empID) {
        empRepo.deleteById(empID);
        return "Employee Deleted Successfully!!!";
    }

}
