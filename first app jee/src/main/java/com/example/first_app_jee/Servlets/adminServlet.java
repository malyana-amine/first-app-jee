package com.example.first_app_jee.Servlets;

import com.example.first_app_jee.Entities.Equipment;
import com.example.first_app_jee.Entities.EquipmentStatus;
import com.example.first_app_jee.Entities.Users;
import com.example.first_app_jee.Services.Users.UserService;
import com.example.first_app_jee.Services.Users.UserServiceImp;
import com.example.first_app_jee.Services.Equipment.equipmentService;
import com.example.first_app_jee.Services.Equipment.equipmentServiceImp;
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
    private equipmentService equipmentService = new equipmentServiceImp(); // You should implement EquipmentService and EquipmentServiceImpl

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Equipment> equipmentList = equipmentService.getAllEquipment();
        System.out.println(equipmentList);
        request.setAttribute("equipmentList", equipmentList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("adminDashboard.jsp");
        dispatcher.forward(request, response);
    }
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Equipment> equipmentList = equipmentService.getAllEquipment();
//
//        // Log the equipmentList to check if it's populated.
//        for (Equipment equipment : equipmentList) {
//            System.out.println("Equipment: " + equipment.getName()); // Use an appropriate property of the Equipment class.
//        }
//
//        request.setAttribute("equipmentList", equipmentList);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/adminDashboard.jsp");
//        dispatcher.forward(request, response);
//    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        Date dateMantenance = null;
        EquipmentStatus status = EquipmentStatus.Disponible ;


        // Generate a salt for the password


        Equipment equipment = new Equipment(name,dateMantenance,status);

        equipmentService equipmentService = new equipmentServiceImp();
        equipmentService.add(equipment);

        Users user = new Users();


        UserService userService = new UserServiceImp();
        userService.addUser(user);

        response.sendRedirect(request.getContextPath() + "/dashboardAdmin");
    }



}
