package com.example.first_app_jee.Services.Users;

import com.example.first_app_jee.Dao.Equiupment.EquipmentDao;
import com.example.first_app_jee.Dao.Equiupment.EquipmentDaoImp;
import com.example.first_app_jee.Entities.Equipment;

public class equipmentServiceImp implements equipmentService{

    EquipmentDao equipmentDao = new EquipmentDaoImp();
    @Override
    public void add(Equipment equipment) {

        equipmentDao.add(equipment);

    }
}
