package com.example.first_app_jee;

import jakarta.persistence.Persistence;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "",loadOnStartup = 1)
public class Default extends HttpServlet {
    @Override
    public void init(){
        Persistence.createEntityManagerFactory("default");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().println("Hello from DefaultServlet!");
    }
}
