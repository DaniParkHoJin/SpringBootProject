package com.hojin.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class Member {
    private int userNo;
    private String userId;
    private String userPw;
    private String userName;
    private Date regDate;
    private Date updDate;

    private List<MemberAuth> authList;
}
