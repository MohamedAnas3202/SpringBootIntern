package org.example.springbootfirst.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Task {

    @Id
    private int taskId;
    private String title;
    private String description;
    private String status; // YetToStart, InProgress, Completed

    // No-argument constructor
    public Task() {}

    // All-argument constructor
    public Task(int taskId, String title, String description, String status) {
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    // Getters and Setters
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
