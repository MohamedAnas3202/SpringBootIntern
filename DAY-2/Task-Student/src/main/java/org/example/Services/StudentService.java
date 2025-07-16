package org.example.Services;

import org.example.models.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class StudentService {
    List<Student> s = new ArrayList<>(
            Arrays.asList(
            new Student(101,"karthik","cse"),
            new Student(102,"dinesh","ece"))
    );
    public List<Student> getAllStudents(){
        return s;
    }
    public List<Student> addStudents(Student newStudent) {

        s.add(newStudent);

        return s;

    }

    public List<Student> updateStudent(int id, Student updatedStu) {
        for (Student si : s) {
            if (si.getId() == id) {
                si.setName(updatedStu.getName());
                si.setDept(updatedStu.getDept());
                break;
            }
        }
        return s;
    }

    public List<Student> deleteStudent(int id) {
        s.removeIf(si -> si.getId() == id);
        return s;
    }


}
