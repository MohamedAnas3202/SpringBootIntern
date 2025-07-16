package com.training.demo.controllers;
import com.training.demo.models.TaskModel;
import com.training.demo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    TaskService ts;

    @GetMapping("/task")
    public List<TaskModel> getController(){
        return ts.getService();
    }

    @GetMapping("/{id}")
    public TaskModel getControllerId(@PathVariable int id){
        return ts.getIdService(id);
    }

    @PostMapping("/")
    public String postController(@RequestBody TaskModel t){
        ts.postService(t);
        return "Added post";
    }

    @PutMapping("/{id}")
    public TaskModel putController(@PathVariable int id,@RequestBody TaskModel t){
        return ts.putService(id,t);
    }

    @DeleteMapping("/{id}")
    public int deletecontroller(@PathVariable int id){
        return ts.deleteService(id);
    }
}