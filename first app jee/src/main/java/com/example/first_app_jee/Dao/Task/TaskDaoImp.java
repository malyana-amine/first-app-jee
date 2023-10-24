package com.example.first_app_jee.Dao.Task;

import com.example.first_app_jee.Entities.Task;
import com.example.first_app_jee.Entities.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

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

    @Override
    public List<Task> getTaskByUsers(Integer id) {
        EntityManager entityManager = emf.createEntityManager();

        // Use a TypedQuery to retrieve a list of tasks by user ID
        TypedQuery<Task> query = entityManager.createQuery("SELECT t FROM Task t WHERE t.user.id = :id", Task.class);
        query.setParameter("id", id);

        List<Task> tasks = query.getResultList();

        entityManager.close();

        return tasks;
    }
}
