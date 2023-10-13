package com.example.first_app_jee.Services.Users;

import com.example.first_app_jee.Dao.Users.UserDao;
import com.example.first_app_jee.Dao.Users.UserDaoImp;
import com.example.first_app_jee.Entities.Users;

public class UserServiceImp implements UserService{
    UserDao userDao = new UserDaoImp();
    @Override
    public Users addUser(Users users) {


        userDao.add(users);
        return users;
    }
}
