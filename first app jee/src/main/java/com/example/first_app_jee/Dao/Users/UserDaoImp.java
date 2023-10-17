package com.example.first_app_jee.Dao.Users;

import com.example.first_app_jee.Entities.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class UserDaoImp implements UserDao {
    private EntityManagerFactory emf;

    public UserDaoImp() {
        emf = Persistence.createEntityManagerFactory("default");
    }

    @Override
    public void add(Users user) {
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Users getUserByEmail(String email) {
        EntityManager entityManager = emf.createEntityManager();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Users> query = cb.createQuery(Users.class);
        Root<Users> userRoot = query.from(Users.class);

        query.select(userRoot);
        query.where(cb.equal(userRoot.get("email"), email));

        try {
            return entityManager.createQuery(query).getSingleResult();
        } catch (Exception e) {
            // Handle the exception, e.g., user not found
            return null;
        } finally {
            entityManager.close();
        }
    }
}
