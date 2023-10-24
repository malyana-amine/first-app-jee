package com.example.first_app_jee.Dao.Users;

import com.example.first_app_jee.Entities.Equipment;
import com.example.first_app_jee.Entities.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;
import java.util.stream.Collectors;

public class UserDaoImp implements UserDao {
    private EntityManagerFactory emf;

    public UserDaoImp() {
        emf = Persistence.createEntityManagerFactory("default");
    }

    @Override
    public Users add(Users user) {
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
        return user;
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

    @Override
    public Users getUserById(Integer id) {
        EntityManager entityManager = emf.createEntityManager();
        Users users= entityManager.find(Users.class,id);

        return users;
    }

    @Override
    public List<Users> getAllUsers() {
        EntityManager entityManager = emf.createEntityManager();
        List<Users> users = entityManager.createQuery("SELECT u FROM Users u", Users.class).getResultList();
        entityManager.close();
        return users;
//        EntityManager entityManager = emf.createEntityManager();
//        List<Users> users = entityManager.createQuery("select u from Users u", Users.class).getResultList();
////        entityManager.flush();
//        entityManager.close();
////        List<Users> userss = users.stream().filter(users1 -> users1.getId()<2).collect(Collectors.toList());
//        List<Users> userss = users.stream().map(users1 -> {
//            users1.setEmail(users1.getEmail().toLowerCase());
//            return users1;
//        }).collect(Collectors.toList());
////        List<Users> userss = users.stream()
////                .map(users1 -> {
////                    users1.setEmail(users1.getEmail().toLowerCase());
////                    return users1;
////                })
////                .collect(Collectors.toList());
//        System.out.println(userss);
//        return users;
    }
}
