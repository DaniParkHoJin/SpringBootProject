package com.hojin.domin;

import java.time.YearMonth;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Card {

	private String no;
	
	@DateTimeFormat(pattern = "yyyyMMdd")
	private YearMonth validMonth;
	
	
	
}
