package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Task {
    public Task(int taskId, String taskTitle, String taskStatus) {
        this.taskId = taskId;
        this.taskTitle = taskTitle;
        this.taskStatus = taskStatus;
    }

    @Id
    private int taskId;

    public Task() {

    }



    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    private String taskTitle;
    private String taskStatus;
}
