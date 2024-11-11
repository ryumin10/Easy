package com.example.easy.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.ZonedDateTime;

@Table(name="comment")
@Entity
@Getter
@Setter
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
