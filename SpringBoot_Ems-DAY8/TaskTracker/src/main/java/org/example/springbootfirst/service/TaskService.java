package org.example.springbootfirst.service;

import org.example.springbootfirst.model.Task;
import org.example.springbootfirst.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(int id) {
        return taskRepository.findById(id).orElse(null);
    }

    public List<Task> getTasksByStatus(String status) {
        return taskRepository.findByStatus(status);
    }

    public String createTask(Task task) {
        taskRepository.save(task);
        return "Task created successfully!";
    }

    public String updateTask(int id, Task updatedTask) {
        Optional<Task> optional = taskRepository.findById(id);
        if (optional.isPresent()) {
            Task task = optional.get();
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setStatus(updatedTask.getStatus());
            taskRepository.save(task);
            return "Task updated successfully!";
        }
        return "Task not found!";
    }

    public String deleteTaskById(int id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return "Task deleted successfully!";
        }
        return "Task not found!";
    }

    public String deleteAllTasks() {
        taskRepository.deleteAll();
        return "All tasks deleted!";
    }
}
