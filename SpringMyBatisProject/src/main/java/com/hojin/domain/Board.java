package com.hojin.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@ToString
public class Board {

    private int boardNo;
    private String title;
    private String content;
    private String writer;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date regDate;
}