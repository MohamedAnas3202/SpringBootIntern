package com.training.demo.services;
import com.training.demo.models.RegisterDetails;
import com.training.demo.repository.RegisterDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    RegisterDetailsRepository registerDetailsRepository;


    public List<RegisterDetails> getMethod() {
        return registerDetailsRepository.findAll();
    }

    public RegisterDetails getEmployeeById(int empId) {
        return registerDetailsRepository.findById(empId).orElse(new RegisterDetails());
    }

//    public List<RegisterDetails> getEmployeeByJob() {
//        return registerDetailsRepository.findByRole();
//    }
    public String addEmployee(RegisterDetails employee) {
        registerDetailsRepository.save(employee);
        return "Employee Added Successfully";
    }
    @PutMapping("/update")
    public String updateEmployee(int empId, RegisterDetails details) {
        RegisterDetails user = registerDetailsRepository.findById(empId)
                .orElseThrow(()->new RuntimeException("No Such User Present"));
        user.setName(details.getName());
        user.setEmail(details.getEmail());
        user.setUserName(details.getUserName());
        user.setPassword(details.getPassword());
        registerDetailsRepository.save(user);
        return "Employee Updated Successfully";
    }
    public String deleteEmployeeById(int empID) {
        registerDetailsRepository.deleteById(empID);
        return "Employee Deleted Successfully";
    }

    public RegisterDetails getEmployeeByRole(String role) {
        return registerDetailsRepository.findByRole(role).orElse(new RegisterDetails());
    }

}