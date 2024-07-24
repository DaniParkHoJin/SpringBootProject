package com.hojin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BoardController {

	@RequestMapping("/boardjstl/register")
	public void registerForm() {
		log.info("registerForm");

	}

	@RequestMapping("/boardjstl/modify")
	public void modifyForm() {
		log.info("modifyForm");
	}

	@RequestMapping("/boardjstl/list")
	public void list() {
		log.info("list");
	}

	@RequestMapping("/boardjstl/search")
	public void search(String keyword, Model model) {
		log.info("search keyword = " + keyword);
		model.addAttribute("keyword", keyword);
	}
}
