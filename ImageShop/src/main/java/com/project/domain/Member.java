package com.project.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@ToString
public class Member {

  private int userNo;
  @NotBlank
  private String userId;
  @NotBlank
  private String userPw;
  @NotBlank
  private String userName;

  private String job;

  private Integer coin;
  private Date regDate;

  private Date updDate;
  private String enabled;

  private List<MemberAuth> authList;


}
