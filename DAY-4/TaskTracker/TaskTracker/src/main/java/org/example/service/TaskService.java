package org.example.service;

import org.example.model.Task;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private List<Task> tasks = new ArrayList<>();
    public TaskService() {
        // Sample initial tasks
        tasks.add(new Task(1, "DSA", "In Progress"));
        tasks.add(new Task(2, "Spring Boot", "Completed"));
    }


    public List<Task> getAllTasks(){
        return tasks;
    }


    public String createTask(Task t){
        tasks.add(t);
        return "Task added successfully";
    }

    public String updateTask(int taskId,Task t){
        for(int i=0;i<tasks.size();i++){
            if(tasks.get(i).getTaskId() == taskId){
                tasks.set(i,t);
                return "Task Updated Successfully";
            }
        }
        return "Task Not Found";
    }

    public String deleteTask(int taskId){
        for(int i=0;i<tasks.size();i++){
            if(taskId == tasks.get(i).getTaskId()){
                tasks.remove(i);
                return "Task Deleted Successfully";
            }
        }
        return "Task Not Found";
    }
}
