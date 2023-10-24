package com.example.first_app_jee.Services.Task;

import com.example.first_app_jee.Dao.Task.TaskDao;
import com.example.first_app_jee.Dao.Task.TaskDaoImp;
import com.example.first_app_jee.Entities.Task;

public class TaskServiceImp implements TaskService {

    @Override
    public Task addTask(Task task) {
        TaskDao taskDao = new TaskDaoImp();
        Task getTask = taskDao.addTask(task);
        return getTask;
    }
}
