package com.example.first_app_jee.Dao.Equiupment;

import com.example.first_app_jee.Entities.Equipment;

import java.util.List;

public interface EquipmentDao {
    public void add(Equipment equipment);
    List<Equipment> getAllEquipment();
}
