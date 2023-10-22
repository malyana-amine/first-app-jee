package com.example.first_app_jee.Servlets;


import com.example.first_app_jee.Entities.Users;

import com.example.first_app_jee.Services.Users.UserService;
import com.example.first_app_jee.Services.Users.UserServiceImp;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;


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
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String Password = request.getParameter("password"); // Get the plain text password
        String phoneNumber = request.getParameter("phoneNumber");





        Users user = new Users();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);

        user.setPhone(phoneNumber);
        user.setPassword(Password);

        UserService userService = new UserServiceImp();
        userService.addUser(user);

        response.sendRedirect(request.getContextPath() + "/UserServlet");
    }


}
