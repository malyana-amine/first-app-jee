package com.example.first_app_jee.Dao.Reservation;

import com.example.first_app_jee.Entities.Reservation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ReservationDaoImp implements ReservationDao{

    private EntityManagerFactory emf;
    public ReservationDaoImp() {
        emf = Persistence.createEntityManagerFactory("default");
    }
    @Override
    public Reservation addReservation(Reservation reservation) {
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(reservation);
        entityManager.getTransaction().commit();
        entityManager.close();

        return reservation;
    }
}
