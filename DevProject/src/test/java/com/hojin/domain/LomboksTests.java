package com.hojin.domain;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.hojin.domin.*;


@SpringBootTest
public class LomboksTests {
	@Test
	public void testNoArsConstructor() {
		Board board = new Board();
		System.out.println(board);
	}
	@Test
	public void testRequiredArsConstructor() {
	//	Board board = new Board("테스트 제목");
	//	System.out.println(board);
	}
	@Test
	public void testSetter() {
		Board board = new Board();
		board.setTitle("게시판 제목");
		System.out.println(board.toString());
	}
	@Test
	public void testToStringExclude() {
		Member member = new Member();
		System.out.println(member);
	}
	@Test
	public void testAllArgsconstructor() {
		Board board = new Board(1, "테스트 제목1", "테스특 내용1", "홍길동", new Date());
		System.out.println(board);
	}
	
}
