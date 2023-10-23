package com.example.first_app_jee.Servlets;


import com.example.first_app_jee.Entities.Role;
import com.example.first_app_jee.Entities.Users;

//import com.example.first_app_jee.Services.Role.RoleService;
//import com.example.first_app_jee.Services.Role.RoleServiceImp;
import com.example.first_app_jee.Services.Role.RoleService;
import com.example.first_app_jee.Services.Role.RoleServiceImp;
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password"); // Get the plain text password
        String phoneNumber = request.getParameter("phoneNumber");
        Integer roleId = 2;

        // Create a new User instance
        Users user = new Users();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPhone(phoneNumber);
        user.setPassword(password);


        RoleService roleService = new RoleServiceImp();
        Role role = roleService.getRoleById(roleId);

        if (role != null) {
            // Set the Role in the User
            user.setRole(role);

            // Now, save the User entity with the associated Role
            UserService userService = new UserServiceImp();
            userService.addUser(user);

            response.sendRedirect(request.getContextPath() + "UserServlet");
        } else {
            // Handle the case where the Role with the specified ID was not found.
            // You can display an error message to the user or redirect to an error page.
            String errorMessage = "Role with ID " + roleId + " not found.";
            request.setAttribute("error", errorMessage);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/errorPage.jsp"); // Create an error page
            dispatcher.forward(request, response);
        }
    }




}
