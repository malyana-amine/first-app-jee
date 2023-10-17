package com.example.first_app_jee.Servlets;

import com.example.first_app_jee.Entities.Users;
import com.example.first_app_jee.Services.Users.UserService;
import com.example.first_app_jee.Services.Users.UserServiceImp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "loginServlet", urlPatterns = {"/loginServlet"})
public class loginServet extends HttpServlet {
    private EntityManagerFactory emf;

    @Override
    public void init() throws ServletException {
        emf = Persistence.createEntityManagerFactory("default");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        System.out.println(email + password);

        // Validate username and password against your database using JPA
        boolean isValid = validateUser(email, password);

        if (isValid) {
            // Redirect to a success page or perform other actions
            response.sendRedirect("success.jsp");
        } else {
            // Redirect to a failure page or display an error message
            response.sendRedirect("failure.jsp");
        }
    }

    private boolean validateUser(String email, String password) {
        EntityManager em = emf.createEntityManager();
        try {
            UserService userService = new UserServiceImp();
            Users user = userService.getUser(email);

            if (user != null) {
                // You should hash the input password and compare it with the stored password hash
                // For example, using a library like BCrypt
                // if (BCrypt.checkpw(inputPassword, user.getPassword())) {
                //     return true;
                // }
            }
        } finally {
            em.close();
        }
        return false;
    }

    @Override
    public void destroy() {
        emf.close();
        super.destroy();
    }
}
