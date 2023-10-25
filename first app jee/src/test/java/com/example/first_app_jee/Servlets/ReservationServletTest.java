package com.example.first_app_jee.Servlets;

import com.example.first_app_jee.Entities.Equipment;
import com.example.first_app_jee.Entities.EquipmentStatus;
import com.example.first_app_jee.Services.Equipment.EquipmentService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReservationServletTest {

    @Test
    public void test_getAllEquipment_success() {
        // Mock EquipmentService



        EquipmentService equipmentServiceMock = Mockito.mock(EquipmentService.class);
        List<Equipment> equipmentList = new ArrayList<>();
        equipmentList.add(new Equipment("Equipment 1", null, EquipmentStatus.Disponible, false));
        equipmentList.add(new Equipment("Equipment 2", null, EquipmentStatus.Disponible, false));
        Mockito.when(equipmentServiceMock.getAllEquipment()).thenReturn(equipmentList);

        // Create ReservationServlet instance
        ReservationServlet reservationServlet = new ReservationServlet();
        reservationServlet.equipmentService = equipmentServiceMock;

        // Mock HttpServletRequest and HttpServletResponse
        HttpServletRequest requestMock = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse responseMock = Mockito.mock(HttpServletResponse.class);
        RequestDispatcher dispatcherMock = Mockito.mock(RequestDispatcher.class);
        Mockito.when(requestMock.getRequestDispatcher("/Reservation.jsp")).thenReturn(dispatcherMock);

        try {
            // Call doGet method
            reservationServlet.doGet(requestMock, responseMock);

            // Verify that equipmentList is set as an attribute in the request
            Mockito.verify(requestMock).setAttribute("equipmentList", equipmentList);

            // Verify that the request is forwarded to Reservation.jsp
            Mockito.verify(dispatcherMock).forward(requestMock, responseMock);
        } catch (ServletException | IOException e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    void doPost() {
    }
}