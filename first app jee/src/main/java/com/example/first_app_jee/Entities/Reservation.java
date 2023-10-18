package com.example.first_app_jee.Entities;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "user_id") // This should match the name of the foreign key column in your database
    private Users user;

    @ManyToOne
    @JoinColumn(name = "equipment_id", referencedColumnName = "id") // Use referencedColumnName to specify the column in Equipment
    private Equipment equipment;

    // Constructors, getters, setters, and other methods...
}
