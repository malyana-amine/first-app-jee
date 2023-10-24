package com.example.first_app_jee.Servlets;

import com.example.first_app_jee.Entities.Task;
import com.example.first_app_jee.Entities.Users;
import com.example.first_app_jee.Services.Task.TaskService;
import com.example.first_app_jee.Services.Task.TaskServiceImp;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Mytasks", urlPatterns = {"/Mytasks"} )
public class MyTaskServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession httpSession = request.getSession();
        Integer userId = Integer.valueOf(httpSession.getAttribute("userId").toString());
        System.out.println(userId);

        TaskService taskService = new TaskServiceImp();
        List<Task> tasks  = taskService.getTaskByUsers(userId);
        request.setAttribute("tasks", tasks);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/MyTask.jsp");

        dispatcher.forward(request,response);
    }
}
