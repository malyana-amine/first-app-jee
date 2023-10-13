package com.example.first_app_jee.Servlets;

import com.example.first_app_jee.Dao.Users.UserDao;
import com.example.first_app_jee.Dao.Users.UserDaoImp;
import com.example.first_app_jee.Entities.Users;
import com.example.first_app_jee.HelloServlet;
import com.example.first_app_jee.Services.Users.UserService;
import com.example.first_app_jee.Services.Users.UserServiceImp;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet"} )
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        Users user=new Users();
        user.setName(name);
        UserService userService = new UserServiceImp();
        userService.addUser(user);
        response.sendRedirect(request.getContextPath()+"/UserServlet");
        System.out.println(user);
//        new UserServiceImp().add(user);

    }

}
