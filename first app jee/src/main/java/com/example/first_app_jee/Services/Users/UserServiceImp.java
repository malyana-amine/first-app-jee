package com.example.first_app_jee.Services.Users;

import com.example.first_app_jee.Dao.Users.UserDao;
import com.example.first_app_jee.Dao.Users.UserDaoImp;
import com.example.first_app_jee.Entities.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class UserServiceImp implements UserService{
    UserDao userDao = new UserDaoImp();
    @Override
    public Users addUser(Users users) {


        userDao.add(users);
        return users;
    }
    @Override
    public Users getUser(String email) {

       return userDao.getUserByEmail(email);
//
    }

    @Override
    public Users getUserById(Integer id) {
        UserDao userDao = new UserDaoImp();
        userDao.getUserById(id);
        return userDao.getUserById(id);
    }


}
