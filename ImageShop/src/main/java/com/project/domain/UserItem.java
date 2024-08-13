package com.project.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class UserItem {

    private Integer userItemNo;
    private Integer userNo;

    private Integer itemId;
    private String itemName;
    private Integer price;
    private String description;
    private String pictureUrl;

    private Date regDate;
}
