package com.hojin.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hojin.domain.Board;
import com.hojin.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board")
@MapperScan(basePackages = "com.hojin.mapper")
public class BoardController {

	@Autowired
	private BoardService service;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	private void registerForm(Board board, Model model) {
		log.info("rigisterForm");
	}

	// 제목에 값을 입력하지 않아서 유효성 검증 예외 발생
	// BindingResult에는 요청 데이터의 바인딩 에러와 검사 에러 정보가 저장된다.
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@Validated Board board, BindingResult result, Model model) throws Exception {
		log.info("register");
		// BindingResult가 에러 정보를 가지면 다시 입력 화면으로 돌아간다.
		if (result.hasErrors()) {
			return "board/register";
		}

		service.register(board);

		model.addAttribute("msg", "등록이 완료되었습니다.");

		return "board/success";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model) throws Exception {
		log.info("list");
		model.addAttribute("list", service.list());
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("boardNo") int boardNo, Model model) throws Exception {

		log.info("read");
		// 게시글이 존재하지 않으면 예외를 발생시킨다.
		Board board = service.read(boardNo);

		model.addAttribute(service.read(boardNo));
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("boardNo") int boardNo, Model model) throws Exception {
		log.info("remove");

		// MyBatis Mapper 파일에서 쿼리 예외 발생
		service.remove(boardNo);
		model.addAttribute("msg", "삭제가 완료되었습니다.");
		return "board/success";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyForm(@RequestParam("boardNo") int boardNo, Model model) throws Exception {
		log.info("modifyForm");
		model.addAttribute(service.read(boardNo));
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(Board board, Model model) throws Exception {
		log.info("modify");
		service.modify(board);
		model.addAttribute("msg", "수정이 완료되었습니다.");
		return "board/success";
	}
}
