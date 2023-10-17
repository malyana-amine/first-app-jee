package com.example.first_app_jee.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Equipment")
public class Equipment {

    public Equipment(String name, String dateMantenance, EquipmentStatus status) {
        this.name = name;
        this.dateMantenance = dateMantenance;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name") // Corrected the column name
    private String name;
    @Column(name = "dateMantenance") // Corrected the column name
    private String dateMantenance;

    @Column(name = "staus") // Corrected the column name
    private EquipmentStatus status;

    public Equipment() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateMantenance() {
        return dateMantenance;
    }

    public void setDateMantenance(String dateMantenance) {
        this.dateMantenance = dateMantenance;
    }

    public EquipmentStatus getStatus() {
        return status;
    }

    public void setStatus(EquipmentStatus status) {
        this.status = status;
    }
}
