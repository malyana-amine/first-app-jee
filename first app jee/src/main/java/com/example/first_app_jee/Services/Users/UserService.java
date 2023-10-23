package com.example.first_app_jee.Services.Users;

import com.example.first_app_jee.Entities.Users;

import java.util.List;

public interface UserService {
    public Users addUser(Users users);

    public Boolean getUser(String email, String password);

    public Users getUserById(Integer id);

    public Users getUserByEmail(String email);

    public List<Users> getAllUsers();




}
