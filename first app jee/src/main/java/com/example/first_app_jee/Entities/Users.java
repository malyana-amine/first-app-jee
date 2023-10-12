package com.example.first_app_jee.Entities;

import jakarta.persistence.*;


@Entity
@Table (name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // If using an auto-generated ID
    private Long id; // Assuming Long as the ID type

    public Users(String name) {
        this.name = name;
    }

    @Column(name = "name")
    private String name;

    public Users() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
