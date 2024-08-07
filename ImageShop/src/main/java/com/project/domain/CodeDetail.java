package com.project.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class CodeDetail {

    // 테이블과 비교 필요
    private String groupCode;
    private String codeValue;
    private String codeName;
    private int sortSeq;
    private String useYn;
    private Date regDate;
    private Date updDate;

}
