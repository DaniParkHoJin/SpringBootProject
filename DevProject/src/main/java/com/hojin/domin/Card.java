package com.hojin.domin;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Card {

	// 문자열이 아니고 trim한 길이가 0보다 크다는 것을 검사한다.
	@NotBlank
	private String no;
	// 미래 날짜인지를 검사한다.
	@Future
	@DateTimeFormat(pattern = "yyyyMMdd")
	private Date validMonth;
}
