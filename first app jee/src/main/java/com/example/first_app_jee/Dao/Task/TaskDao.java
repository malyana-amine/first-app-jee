package com.example.first_app_jee.Dao.Task;

import com.example.first_app_jee.Entities.Task;

import java.util.List;

public interface TaskDao {
    Task addTask(Task task);
    public List<Task> getTaskByUsers(Integer id);

}
