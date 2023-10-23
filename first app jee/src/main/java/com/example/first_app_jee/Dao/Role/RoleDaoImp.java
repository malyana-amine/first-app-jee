package com.example.first_app_jee.Dao.Role;

import com.example.first_app_jee.Entities.Role;
import com.example.first_app_jee.Entities.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class RoleDaoImp implements RoleDao{

    private EntityManagerFactory emf;
    public RoleDaoImp() {
        emf = Persistence.createEntityManagerFactory("default");
    }
    @Override
    public Role getRoleById(Integer id) {
        EntityManager entityManager = emf.createEntityManager();
        Role role= entityManager.find(Role.class,id);

        return role;
    }
}
