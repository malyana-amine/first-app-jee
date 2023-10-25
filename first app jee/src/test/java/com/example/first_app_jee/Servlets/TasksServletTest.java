package com.example.first_app_jee.Servlets;

import com.example.first_app_jee.Entities.Users;
import com.example.first_app_jee.Services.Users.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TasksServletTest {

    @Test
    public void test_getRequest_returnsListOfUsersAndRendersTasksJsp() throws ServletException, IOException {
        // Arrange
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        UserService userService = mock(UserService.class);
        List<Users> users = new ArrayList<>();
        users.add(new Users("John", "Doe", "1234567890", "john.doe@example.com", "password"));
        when(userService.getAllUsers()).thenReturn(users);
        when(request.getRequestDispatcher("/Tasks.jsp")).thenReturn(dispatcher);

        TasksServlet tasksServlet = new TasksServlet();

        // Act
        tasksServlet.doGet(request, response);

        // Assert
        verify(request).setAttribute("Users", users);
        verify(dispatcher).forward(request, response);
    }

    @Test
    void doGet() {
    }

    @Test
    void doPost() {
    }
}