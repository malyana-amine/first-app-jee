package com.example.first_app_jee.Services.Role;

import com.example.first_app_jee.Dao.Role.RoleDao;
import com.example.first_app_jee.Dao.Role.RoleDaoImp;
import com.example.first_app_jee.Entities.Role;

public class RoleServiceImp implements RoleService{
    @Override
    public Role getRoleById(Integer id) {
        RoleDao roleDao = new RoleDaoImp();
        Role role = roleDao.getRoleById(id);
        return role;
    }
}
