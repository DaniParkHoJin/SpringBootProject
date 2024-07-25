package com.hojin.domin;

import java.time.LocalDate;
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
	private String gender;
	
	private LocalDate dateOfBirth;
	
	private boolean foreigner;
	
	private Address address;
	
	private List<Card> cardList;
	
	private String hobby;
	private String[] hobbyArray;
	private List<String> hobbyList;

}
