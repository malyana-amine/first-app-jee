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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@WebServlet(name = "loginServlet", urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {
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
                // Retrieve the stored salt for the user
                String salt = user.getSalt();

                // Hash the input password with the retrieved salt
                String hashedPassword = hashPassword(password, salt);

                // Compare the hashed input password with the stored hashed password
                if (hashedPassword.equals(user.getPassword())) {
                    return true;
                }
            }
        } finally {
            em.close();
        }
        return false;
    }

    // Method to hash the password with salt
    private @Nullable String hashPassword(String password, String salt) {
        try {
            String passwordWithSalt = password + salt;
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedPasswordBytes = md.digest(passwordWithSalt.getBytes());

            return bytesToHex(hashedPasswordBytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Helper method to convert byte array to hexadecimal string
    private @NotNull String bytesToHex(byte @NotNull [] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }

    @Override
    public void destroy() {
        emf.close();
        super.destroy();
    }
}
