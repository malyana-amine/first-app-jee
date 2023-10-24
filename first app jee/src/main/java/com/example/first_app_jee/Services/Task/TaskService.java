package com.example.first_app_jee.Services.Task;

import com.example.first_app_jee.Entities.Task;

import java.util.List;

public interface TaskService {
    Task addTask(Task task);
    public List<Task> getTaskByUsers(Integer id);
}
