package com.example.first_app_jee.Services.Users;

import com.example.first_app_jee.Dao.Users.UserDao;
import com.example.first_app_jee.Dao.Users.UserDaoImp;
import com.example.first_app_jee.Entities.Role;
import com.example.first_app_jee.Entities.Users;
import com.example.first_app_jee.Util.PasswordHasher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class UserServiceImp implements UserService{
    UserDao userDao = new UserDaoImp();

    @Override
    public Users addUser(Users user) {
        PasswordHasher passwordHasher = new PasswordHasher();
        user.setPassword(passwordHasher.hash(user.getPassword()));

        // Set the role to "employee" with ID 2
//        user.setRole(new Role(2, "emploee"));

        userDao.add(user);
        return user;
    }

    @Override
    public Boolean getUser(String email, String password) {

        Users user = userDao.getUserByEmail(email);


        if(user==null || user.getEmail()==null){return false ;}
        return PasswordHasher.verify(user.getPassword(), password);
//
    }

    @Override
    public Users getUserById(Integer id) {

        userDao.getUserById(id);
        return userDao.getUserById(id);
    }

    @Override
    public Users getUserByEmail(String email) {
        return userDao.getUserByEmail(email);

    }

    @Override
    public List<Users> getAllUsers() {
        return userDao.getAllUsers();
    }


}
