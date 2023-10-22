package com.example.first_app_jee.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "user_id") // This should match the name of the foreign key column in your database
    private Users user;

    @ManyToOne
    @JoinColumn(name = "equipment_id", referencedColumnName = "id") // Use referencedColumnName to specify the column in Equipment
    private Equipment equipment;

    public Reservation(LocalDate startDate, LocalDate endDate, Users user, Equipment equipment) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.user = user;
        this.equipment = equipment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
}
