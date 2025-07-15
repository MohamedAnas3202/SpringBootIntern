package com.example.springbootfirst.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
public class Employee {
    @Id
    private int empId;
    private String name;
    private String job;

    // Constructors
    public Employee() {}
    public Employee(int empId, String name, String job) {
        this.empId = empId;
        this.name = name;
        this.job = job;
    }

    // Getters and Setters
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
