package org.example.services;

import org.example.models.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class HelloWorldService {

    List<Employee> emp = new ArrayList<>(
            Arrays.asList(
                    new Employee(1,"prasanth","Trainner"),
                    new Employee(2,"Yuvaraj","Faculty"))
            );

    public List<Employee> getMethod(){
        return emp;
    }

    public List<Employee> postMethod(Employee newEmployee) {

        emp.add(newEmployee);

        return emp;

    }
    public List<Employee> putMethod(int id, Employee updatedEmp) {
        for (Employee e : emp) {
            if (e.getEmpId() == id) {
                e.setName(updatedEmp.getName());
                e.setJob(updatedEmp.getJob());
                break;
            }
        }
        return emp;
    }

    public List<Employee> deleteMethod(int id) {
        emp.removeIf(e -> e.getEmpId() == id);
        return emp;
    }

}
