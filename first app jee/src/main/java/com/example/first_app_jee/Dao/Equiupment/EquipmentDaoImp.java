package com.example.first_app_jee.Dao.Equiupment;

import com.example.first_app_jee.Entities.Equipment;
import com.example.first_app_jee.Entities.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

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
    @Override
    public List<Equipment> getAllEquipment() {
        EntityManager entityManager = emf.createEntityManager();
        List<Equipment> equipmentList = entityManager.createQuery("SELECT e FROM Equipment e", Equipment.class).getResultList();
        entityManager.close();
        return equipmentList;
    }

    @Override
    public Equipment getEquipmentById(Integer id) {
        EntityManager entityManager = emf.createEntityManager();
        Equipment equipment= entityManager.find(Equipment.class,id);

        return equipment;
    }

    @Override
    public void deleteEquipment(int equipmentId) {
        EntityManager entityManager = emf.createEntityManager();
        Equipment equipment = entityManager.find(Equipment.class, equipmentId);
        if (equipment != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(equipment);
            entityManager.getTransaction().commit();
        }
        entityManager.close();
    }


}
