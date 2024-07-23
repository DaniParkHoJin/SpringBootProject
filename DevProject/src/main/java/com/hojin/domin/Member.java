package com.hojin.domin;

import lombok.ToString;
// 롬복
@ToString(exclude = "userName")
public class Member {
private String userId;
private String userName;
private String password;
}
