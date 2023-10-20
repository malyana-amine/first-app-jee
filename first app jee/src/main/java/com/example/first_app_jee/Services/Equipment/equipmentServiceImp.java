package com.example.first_app_jee.Services.Equipment;

import com.example.first_app_jee.Dao.Equiupment.EquipmentDao;
import com.example.first_app_jee.Dao.Equiupment.EquipmentDaoImp;
import com.example.first_app_jee.Entities.Equipment;

import java.util.List;

public class equipmentServiceImp implements equipmentService{

    EquipmentDao equipmentDao = new EquipmentDaoImp();
    @Override
    public void add(Equipment equipment) {

        equipmentDao.add(equipment);

    }
    @Override
    public List<Equipment> getAllEquipment() {
        List<Equipment> equipment = equipmentDao.getAllEquipment();
        System.out.println(equipment);
        return equipment;
    }
    @Override
    public void deleteEquipment(int equipmentId) {
        equipmentDao.deleteEquipment(equipmentId);
    }

}
