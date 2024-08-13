package com.project.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class ChargeCoin {
    private Integer historyNo;
    private Integer userNo;
    private Integer amount;
    private Date regDate;
}
