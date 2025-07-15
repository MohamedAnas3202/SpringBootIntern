package org.example.services;

import org.example.models.Employee;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

    public Employee getEmployeeById(int empId){
        int index = 0;
        boolean flag = false;
        for(int i=0;i<emp.size();i++){
            if(empId == emp.get(i).getEmpId()){
                System.out.println("Emp id : "+emp.get(i).getEmpId()+emp.get(i));
                index = i;
                flag = true;
            }
        }
        if(flag) return emp.get(index);
        else return new Employee();
    }
    public String postMethod(Employee newEmployee) { //List<Employee>

        emp.add(newEmployee);
//      return emp; this will return the employee details as list
        return "Employee added successfully";

    }

    @DeleteMapping("/{empId}")
    public String deleteEmployeeById(@PathVariable int empId) {
        int index = -1;
        boolean flag = false;
        for (int i = 0; i < emp.size(); i++) {
            if (empId == emp.get(i).getEmpId()) {
                System.out.println("Emp id: " + emp.get(i).getEmpId() + " " + emp.get(i));
                index = i;
                flag = true;
                break;
            }
        }
        if (flag) {
            emp.remove(index);
            return "Employee Deleted Successfully";
        } else {
            return "No Such Employees";
        }
    }



    @PutMapping("/{empId}")
    public String updateEmployee(int empId, Employee updatedEmp) {
        int index = -1;
        boolean flag = false;
        for (int i = 0; i < emp.size(); i++) {
            if (empId == emp.get(i).getEmpId()) {
                System.out.println("Emp id: " + emp.get(i).getEmpId() + " " + emp.get(i));
                index = i;
                flag = true;
                break;
            }
        }
        if (flag) {
            emp.set(index, updatedEmp);
            return "Employee Updated Successfully";
        } else {
            return "No Such Employees";
        }
    }




}
