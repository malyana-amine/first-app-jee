package com.example.first_app_jee.Servlets;

import com.example.first_app_jee.Entities.Equipment;
import com.example.first_app_jee.Entities.Users;
import com.example.first_app_jee.Services.Users.UserService;
import com.example.first_app_jee.Services.Users.UserServiceImp;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "tasks", urlPatterns = {"/tasks"} )
public class TasksServlet extends HttpServlet {

    UserService userService = new UserServiceImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Users> Users = userService.getAllUsers();
//        System.out.println(equipmentList);
        request.setAttribute("Users", Users);


        RequestDispatcher dispatcher = request.getRequestDispatcher("/Tasks.jsp");

        dispatcher.forward(request,response);
    }

}
