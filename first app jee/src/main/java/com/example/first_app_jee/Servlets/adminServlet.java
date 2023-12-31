package com.example.first_app_jee.Servlets;

import com.example.first_app_jee.Entities.Equipment;
import com.example.first_app_jee.Entities.EquipmentStatus;
import com.example.first_app_jee.Entities.Users;
import com.example.first_app_jee.Services.Users.UserService;
import com.example.first_app_jee.Services.Users.UserServiceImp;
import com.example.first_app_jee.Services.Equipment.EquipmentService;
import com.example.first_app_jee.Services.Equipment.EquipmentServiceImp;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "dashboardAdmin", urlPatterns = {"/dashboardAdmin"} )
public class adminServlet extends HttpServlet {
    private EquipmentService equipmentService = new EquipmentServiceImp(); // You should implement EquipmentService and EquipmentServiceImpl

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("delete")) {
            // Delete the equipment
            int equipmentId = Integer.parseInt(request.getParameter("id"));
            equipmentService.deleteEquipment(equipmentId);
        }

        List<Equipment> equipmentList = equipmentService.getAllEquipment();
        System.out.println(equipmentList);
        request.setAttribute("equipmentList", equipmentList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("adminDashboard.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        Date dateMantenance = null;
        EquipmentStatus status = EquipmentStatus.Disponible ;
        Boolean isReserved = false;


        // Generate a salt for the password


        Equipment equipment = new Equipment(name,dateMantenance,status,isReserved);

        EquipmentService equipmentService = new EquipmentServiceImp();
        equipmentService.add(equipment);

        Users user = new Users();


        UserService userService = new UserServiceImp();
        userService.addUser(user);

        response.sendRedirect(request.getContextPath() + "/dashboardAdmin");
    }



}
