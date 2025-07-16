package com.training.demo.services;
import com.training.demo.models.Student;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {
    public List<Student> getAllStudents() {
        return Arrays.asList(
                new Student(1, "Aravinthan", "Python+DS"),
                new Student(2, "Abi", "DataScience"),
                new Student(3, "Balan", "ComputerScience")
        );
    }
}