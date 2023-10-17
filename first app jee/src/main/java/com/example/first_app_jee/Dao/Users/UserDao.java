package com.example.first_app_jee.Dao.Users;

import com.example.first_app_jee.Entities.Users;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public interface UserDao {

    public void add(Users user);

    public Users getUserByEmail(String email);


}
