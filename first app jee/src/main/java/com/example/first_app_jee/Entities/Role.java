package com.example.first_app_jee.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "roles") // Corrected the table name
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_name") // Corrected the column name
    private String roleName;

    public Role(int i, String emploee) {
    }

    public Role() {

    }

    // Getter and setter methods for the fields

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
