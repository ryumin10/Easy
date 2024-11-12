package com.example.easy.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name="admin")
@Entity
@Getter
@Setter
public class AdminEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_no")
    private int adminNo;

    @Column(name = "admin_id")
    private String adminId;

    @Column(name = "admin_password")
    private String adminPassword;
}
