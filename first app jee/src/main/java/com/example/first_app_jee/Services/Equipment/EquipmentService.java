package com.example.first_app_jee.Services.Equipment;

import com.example.first_app_jee.Entities.Equipment;

import java.util.List;

public interface EquipmentService {
    public void add(Equipment equipment);
    public List<Equipment> getAllEquipment();
    public Equipment getEquipmentById(Integer id);
    void deleteEquipment(int equipmentId);

}
