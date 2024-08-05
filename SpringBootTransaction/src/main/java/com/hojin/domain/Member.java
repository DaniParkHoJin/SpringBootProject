package com.hojin.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
@ToString
public class Member implements Serializable {
    private static final long serialVersionUID = 1L;

    private int userNo;
    private String userId;
    private String userPw;
    private String userName;
    private Date regDate;
    private Date updDate;

    private String auth;
}
