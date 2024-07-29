package com.hojin.domin;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 롬복
@Getter
@Setter
@ToString
public class Member {
	// 입력값 검증 규칙을 지정한다.
	@NotBlank
	private String userId;
	private String password;
	// 여러 개의 입력값 검증 규칙을 지정할 수 있다.
	@NotBlank
	@Size(max = 3)
	private String userName;
	private String email;
	private String gender;
	// 입력값의 날짜 형식을 지정한다.
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;

}
