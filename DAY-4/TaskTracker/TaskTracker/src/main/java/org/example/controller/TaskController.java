package org.example.controller;

import org.example.model.Task;
import org.example.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class TaskController {

    @Autowired
    TaskService ts;

    @GetMapping
    public List<Task> getAllTasks(){
        return ts.getAllTasks();
    }

    @PostMapping
    public String createTask(@RequestBody Task t){
        return ts.createTask(t);
    }

    @PutMapping("/{taskId}")
    public String updateTask(@PathVariable int taskId,@RequestBody Task t){
        return ts.updateTask(taskId,t);
    }

    @DeleteMapping("/{taskId}")
    public String deleteTask(@PathVariable int taskId){
        return ts.deleteTask(taskId);
    }


}
