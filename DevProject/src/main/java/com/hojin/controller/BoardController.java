package com.hojin.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hojin.domin.Board;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {

	@GetMapping(value = "/get", params = "register")
	public String registerForm() {
		log.debug("Params 파라미터 GET 방식 등록 폼");
		return "board/register";
	}

	@PostMapping(value = "/post", params = "register")
	public String register() {
		log.debug("params 파라미터 POST 방식 등록");
		return "board/list";
	}

	@GetMapping(value = "/get", params = "modify")
	public String modifyForm() {
		log.debug("params 파라미터 GET 방식 수정 폼");
		return "board/modify";
	}

	@PostMapping(value = "/post", params = "modify")
	public String modify() {
		log.debug("params 파라미터 POST 방식 수정");
		return "board/list";
	}

	@GetMapping(value = "/get", params = "remove")
	public String removeForm() {
		log.debug("params 파라미터 GET 방식 삭제 폼");
		return "board/remove";
	}

	@PostMapping(value = "/post", params = "remove")
	public String remove() {
		log.debug("params 파라미터 POST 방식 삭제");
		return "board/list";
	}

	@GetMapping(value = "/get", params = "list")
	public String list() {
		log.debug("params 파라미터 GET 방식 목록");
		return "board/list";
	}

	@GetMapping(value = "/get", params = "read")
	public String read() {
		log.debug("params 파라미터 GET 방식 읽기");
		return "board/read";
	}

	@PutMapping(value = "/{boardNo}")
	public ResponseEntity<String> modify(@PathVariable("boardNo") int boardNo) {
		log.debug("수정");

		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

		return entity;
	}

	// X-HTTP-Method-Override 요청 헤더 값을 "PUT"으로 지정
	@PutMapping(value = "/{boardNo}", headers = "X-HTTP-Method-Override=PUT")
	public ResponseEntity<String> modifyByHeader(@PathVariable("boardNo") int boardNo, @RequestBody Board board) {
		log.debug("헤더 수정");
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}

	@PostMapping(value = "/{boardNo}")
	public ResponseEntity<String> modify(@PathVariable("boardNo") int boardNo, @RequestBody Board board) {
		log.debug("modify");
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}

	// consumes 속성값에 "application/json" 미디어 타입을 지정한다.
	@PutMapping(value = "/{boardNo}", consumes = "application/json")
	public ResponseEntity<String> modifyByJson(@PathVariable("boardNo") int boardNo, @RequestBody Board board) {
		log.debug("modifyByJson");
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}

	// consumes 속성값에 "application/xml" 미디어 타입을 지정한다.
	@PutMapping(value = "/{boardNo}", consumes = "application/xml")
	public ResponseEntity<String> modifyByXml(@PathVariable("boardNo") int boardNo, @RequestBody Board board) {
		log.info("modifyByXml boardNo : " + boardNo);
		log.info("modifyByXml board : " + board);
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}

	// produces 속성값에 "application/xml" 미디어 타입을 지정한다.
	@GetMapping(value = "/{boardNo}", produces = "application/xml")
	public ResponseEntity<Board> readToXml(@PathVariable("boardNo") int boardNo) {
		log.info("readToXml");
		Board board = new Board();
		board.setBoardNo(boardNo);
		board.setTitle("제목");
		board.setContent("내용입니다.");
		board.setWriter("홍길동");
		board.setRegDate(new Date());
		ResponseEntity<Board> entity = new ResponseEntity<Board>(board, HttpStatus.OK);
		return entity;
	}

	// produces 속성값에 "application/json" 미디어 타입을 지정한다.
	@GetMapping(value = "/{boardNo}", produces = "application/json")
	public ResponseEntity<Board> readToJson(@PathVariable("boardNo") int boardNo) {
		log.info("readToJson");

		Board board = new Board();

		board.setBoardNo(boardNo);
		board.setTitle("제목");
		board.setContent("내용입니다.");
		board.setWriter("홍길동");
		board.setRegDate(new Date());
		ResponseEntity<Board> entity = new ResponseEntity<Board>(board, HttpStatus.OK);
		return entity;
	}

	// 응답 본문의 미디어 타입을 지정하지 않으면 기본값인 "application/json"으로 지정된다.
	@GetMapping(value = "/{boardNo}")
	public ResponseEntity<Board> read(@PathVariable("boardNo") int boardNo) {
		log.info("read");
		
		Board board = new Board();
		board.setBoardNo(boardNo);
		board.setTitle("제목");
		board.setContent("내용입니다.");
		board.setWriter("홍길동");
		board.setRegDate(new Date());
		ResponseEntity<Board> entity = new ResponseEntity<Board>(board, HttpStatus.OK);
		return entity;
	}
}
