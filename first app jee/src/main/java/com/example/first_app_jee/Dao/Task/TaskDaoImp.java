package com.example.first_app_jee.Dao.Task;

import com.example.first_app_jee.Entities.Task;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TaskDaoImp implements TaskDao{
    private EntityManagerFactory emf;
    public TaskDaoImp() {
        emf = Persistence.createEntityManagerFactory("default");
    }
    @Override
    public Task addTask(Task task) {
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(task);
        entityManager.getTransaction().commit();
        entityManager.close();

        return task;
    }
}
