package org.example.springbootfirst.controller;

import org.example.springbootfirst.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@CrossOrigin
public class TaskController {

    @Autowired
    private org.example.springbootfirst.service.TaskService ts;

    @GetMapping("/")
    public String home() {
        return "Task Tracker API is running!";
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return ts.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable int id) {
        return ts.getTaskById(id);
    }

    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable String status) {
        return ts.getTasksByStatus(status);
    }

    @PostMapping
    public String createTask(@RequestBody Task task) {
        return ts.createTask(task);
    }

    @PutMapping("/{id}")
    public String updateTask(@PathVariable int id, @RequestBody Task updatedTask) {
        return ts.updateTask(id, updatedTask);
    }

    @DeleteMapping("/{id}")
    public String deleteTaskById(@PathVariable int id) {
        return ts.deleteTaskById(id);
    }

    @DeleteMapping
    public String deleteAllTasks() {
        return ts.deleteAllTasks();
    }
}
