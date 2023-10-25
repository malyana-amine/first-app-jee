package com.example.first_app_jee.Dao.Reservation;

import com.example.first_app_jee.Entities.Equipment;
import com.example.first_app_jee.Entities.Reservation;

import com.example.first_app_jee.Entities.Users;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertNotNull;

public class ReservationDaoImpTest {

    @Test
    public void test_successfully_adds_reservation() {
        // Arrange
        ReservationDaoImp reservationDao = new ReservationDaoImp();
        Reservation reservation = new Reservation(LocalDate.now(), LocalDate.now().plusDays(1), new Users(), new Equipment());

        // Act
        Reservation addedReservation = reservationDao.addReservation(reservation);

        // Assert
        assertNotNull(addedReservation.getId());
    }

}
