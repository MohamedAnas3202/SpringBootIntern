package com.example.springbootfirst.Services;

import com.example.springbootfirst.models.Employee;
import com.example.springbootfirst.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int empId) {
        return employeeRepository.findById(empId).orElse(null);
    }

    public List<Employee> getEmployeeByName(String name) {
        return employeeRepository.findByName(name);
    }

    public List<Employee> getEmployeeByJob(String job) {
        return employeeRepository.findByJob(job);
    }

    public String createEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "Employee added successfully!";
    }

    public String updateEmployee(int empId, Employee updatedEmp) {
        Optional<Employee> optional = employeeRepository.findById(empId);
        if (optional.isPresent()) {
            Employee emp = optional.get();
            emp.setName(updatedEmp.getName());
            emp.setJob(updatedEmp.getJob());
            employeeRepository.save(emp);
            return "Employee updated successfully!";
        } else {
            return "Employee not found!";
        }
    }


    public String deleteEmployeeById(int empId) {
        if (employeeRepository.existsById(empId)) {
            employeeRepository.deleteById(empId);
            return "Employee deleted successfully!";
        } else {
            return "Employee not found!";
        }
    }

    public String deleteAllEmployees() {
        employeeRepository.deleteAll();
        return "All employees deleted!";
    }
}
