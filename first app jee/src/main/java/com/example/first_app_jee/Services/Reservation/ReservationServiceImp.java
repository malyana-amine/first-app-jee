package com.example.first_app_jee.Services.Reservation;

import com.example.first_app_jee.Dao.Reservation.ReservationDao;
import com.example.first_app_jee.Dao.Reservation.ReservationDaoImp;
import com.example.first_app_jee.Entities.Reservation;

public class ReservationServiceImp implements ReservationService{


    @Override
    public Reservation addReservation(Reservation reservation) {
        ReservationDao reservationDao = new ReservationDaoImp();
        reservationDao.addReservation(reservation);
        return reservation;
    }
}
