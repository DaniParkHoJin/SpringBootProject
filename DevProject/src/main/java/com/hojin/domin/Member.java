package com.hojin.domin;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 롬복
@Getter
@Setter
@ToString
public class Member {
	
	private String userId;
	private String password;
	private String userName;
	private String email;
}
