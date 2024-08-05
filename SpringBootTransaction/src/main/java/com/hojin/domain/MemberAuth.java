package com.hojin.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
@Setter
@Getter
@ToString
public class MemberAuth implements Serializable {
    private static final long serialVersionUID = 1L;

    private int userNo;
    private String auth;

}
