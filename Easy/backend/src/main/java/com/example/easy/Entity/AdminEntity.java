package com.example.easy.Entity;

import jakarta.persistence.*;

@Table(name="admin")
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
