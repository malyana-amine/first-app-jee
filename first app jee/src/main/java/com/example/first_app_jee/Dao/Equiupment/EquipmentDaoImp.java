package com.example.first_app_jee.Dao.Equiupment;

import com.example.first_app_jee.Entities.Equipment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EquipmentDaoImp implements EquipmentDao {

    private EntityManagerFactory emf;
    public EquipmentDaoImp() {
        emf = Persistence.createEntityManagerFactory("default");
    }

    @Override
    public void add(Equipment equipment) {

        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(equipment);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
