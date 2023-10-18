package com.example.first_app_jee.Entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Equipment")
public class Equipment {
    public Equipment(String name, Date dateMaintenance, EquipmentStatus status) {
        this.name = name;
        this.dateMaintenance = dateMaintenance;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "dateMantenance")
    private Date dateMaintenance;

    @Column(name = "status")
    private EquipmentStatus status;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateMaintenance() {
        return dateMaintenance;
    }

    public void setDateMaintenance(Date dateMaintenance) {
        this.dateMaintenance = dateMaintenance;
    }

    public EquipmentStatus getStatus() {
        return status;
    }

    public void setStatus(EquipmentStatus status) {
        this.status = status;
    }

    public Equipment() {

    }
}
