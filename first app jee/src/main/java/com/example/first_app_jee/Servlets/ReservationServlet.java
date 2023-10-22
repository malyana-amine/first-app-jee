package com.example.first_app_jee.Servlets;


import com.example.first_app_jee.Entities.Equipment;
import com.example.first_app_jee.Entities.Reservation;
import com.example.first_app_jee.Entities.Users;
import com.example.first_app_jee.Services.Equipment.EquipmentService;
import com.example.first_app_jee.Services.Equipment.EquipmentServiceImp;
import com.example.first_app_jee.Services.Reservation.ReservationService;
import com.example.first_app_jee.Services.Reservation.ReservationServiceImp;
import com.example.first_app_jee.Services.Users.UserService;
import com.example.first_app_jee.Services.Users.UserServiceImp;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@WebServlet(name = "reservation", urlPatterns = {"/reservation"} )
public class ReservationServlet extends HttpServlet {
    EquipmentService equipmentService = new EquipmentServiceImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Equipment> equipmentList = equipmentService.getAllEquipment();
        System.out.println(equipmentList);
        request.setAttribute("equipmentList", equipmentList);


        RequestDispatcher dispatcher = request.getRequestDispatcher("/Reservation.jsp");

        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer equipmentId = Integer.valueOf(request.getParameter("equipment_id"));
        LocalDate endDate = LocalDate.parse(request.getParameter("end_date"));
        Integer userid = 1;
        LocalDate startdate = LocalDate.now();

        UserService userService = new UserServiceImp();

        Users users = userService.getUserById(userid);

        EquipmentService equipmentService = new EquipmentServiceImp();

        Equipment equipment = equipmentService.getEquipmentById(equipmentId);

        Reservation reservation = new Reservation(startdate,endDate,users,equipment);


        ReservationService reservationService = new ReservationServiceImp();
        reservationService.addReservation(reservation);


        response.sendRedirect(request.getContextPath() + "/dashboardAdmin");



    }
}
