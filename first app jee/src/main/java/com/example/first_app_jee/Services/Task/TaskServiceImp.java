package com.example.first_app_jee.Services.Task;

import com.example.first_app_jee.Dao.Task.TaskDao;
import com.example.first_app_jee.Dao.Task.TaskDaoImp;
import com.example.first_app_jee.Entities.Task;

import java.util.List;

public class TaskServiceImp implements TaskService {
    TaskDao taskDao = new TaskDaoImp();

    @Override
    public Task addTask(Task task) {

        Task getTask = taskDao.addTask(task);
        return getTask;
    }

    @Override
    public List<Task> getTaskByUsers(Integer id){
        return  taskDao.getTaskByUsers(id);
    }
}
