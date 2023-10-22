package com.example.first_app_jee.Services.Users;

import com.example.first_app_jee.Entities.Users;

public interface UserService {
    public Users addUser(Users users);

    public Users getUser(String email);

    public Users getUserById(Integer id);


}
