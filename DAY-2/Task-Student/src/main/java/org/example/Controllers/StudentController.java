package org.example.Controllers;

import org.example.Services.StudentService;
import org.example.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService ss;

    @GetMapping("/")

    public List<Student> getMethod(){
        return ss.getAllStudents();
    }

    @PostMapping("/")
    public List<Student> postMethod(@RequestBody Student s) {
        return ss.addStudents(s);
    }

    @PutMapping("/{id}")
    public List<Student> putMethod(@PathVariable int id, @RequestBody Student s) {
        return ss.updateStudent(id, s);
    }

    @DeleteMapping("/{id}")
    public List<Student> deleteById(@PathVariable int id) {
        return ss.deleteStudent(id);  // Write a method that removes employee by ID
    }

}
