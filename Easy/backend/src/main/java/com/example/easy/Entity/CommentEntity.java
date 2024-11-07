package com.example.easy.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.ZonedDateTime;

@Table(name="comment")
public class CommentEntity {
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "board_no", referencedColumnName = "board_no")
    private BoardEntity boardEntity;

    @Column(name = "comment_text")
    private String commentText;

    @UpdateTimestamp
    @Column(name = "comment_date")
    private ZonedDateTime commentDate;
}
