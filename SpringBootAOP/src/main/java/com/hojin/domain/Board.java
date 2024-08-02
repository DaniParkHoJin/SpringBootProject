package com.hojin.domain;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Board {
	
	private int boardNo;
	
	@NotBlank
	private String title;
	
	private String content;
	
	private String writer;
	
	private Date regDate;
	
}
