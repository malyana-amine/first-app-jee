package com.example.first_app_jee.Dao.Users;

import com.example.first_app_jee.Entities.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserDaoImp implements UserDao {
    @Override
    public void add(Users user) {
        System.out.println("yaes");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = emf.createEntityManager();
        System.out.println("no");

        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();


    }
}