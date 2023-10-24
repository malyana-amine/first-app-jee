package com.example.first_app_jee.Servlets;


import com.example.first_app_jee.Entities.TachStatus;
import com.example.first_app_jee.Entities.Task;
import com.example.first_app_jee.Entities.Users;
import com.example.first_app_jee.Services.Task.TaskService;
import com.example.first_app_jee.Services.Task.TaskServiceImp;
import com.example.first_app_jee.Services.Users.UserService;
import com.example.first_app_jee.Services.Users.UserServiceImp;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "tasks", urlPatterns = {"/tasks"} )
public class TasksServlet extends HttpServlet {

    UserService userService = new UserServiceImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Users> Users = userService.getAllUsers();
        request.setAttribute("Users", Users);


        RequestDispatcher dispatcher = request.getRequestDispatcher("/Tasks.jsp");

        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer userId = Integer.valueOf(request.getParameter("user_id"));
        LocalDate endDate = LocalDate.parse(request.getParameter("end_date"));
        String description = request.getParameter("description");
        LocalDate startdate = LocalDate.now();
        String statusString = request.getParameter("status");
        TachStatus status = TachStatus.valueOf(statusString);

        UserService userService = new UserServiceImp();

        Users users = userService.getUserById(userId);

        Task task = new Task(description,status,startdate,endDate,users);

        TaskService taskService = new TaskServiceImp();

        taskService.addTask(task);

        response.sendRedirect(request.getContextPath() + "/tasks");

    }

}
