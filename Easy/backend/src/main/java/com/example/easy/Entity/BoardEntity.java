package com.example.easy.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.ZonedDateTime;

@Table(name = "board")
public class BoardEntity {
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserEntity userEntity;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_no")
    private int boardNo;

    @Column(name= "category_name")
    private String categoryName;

    @Column(name = "board_name")
    private String boardName;

    @Column(name = "board_text")
    private String boardText;

    @UpdateTimestamp
    @Column(name = "board_date")
    private ZonedDateTime boardDate;
}
