package com.example.easy.Board;

import lombok.Getter;
import lombok.Setter;
import java.time.ZonedDateTime;

@Getter
@Setter
public class BoardDTO {
    private int userNo;
    private int boardNo;
    private String categoryName;
    private String boardName;
    private String boardText;
    private ZonedDateTime boardDate;
}
