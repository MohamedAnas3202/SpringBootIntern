package org.example.models;

public class Employee {
    public Employee() {

    }

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

    private int empId;
    private String name;
    private String job;
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }



    public Employee(int empId, String name, String job) {
        this.empId = empId;
        this.name = name;
        this.job = job;
    }
}
