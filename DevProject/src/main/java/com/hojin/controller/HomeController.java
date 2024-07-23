package com.hojin.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import lombok.extern.slf4j.Slf4j;

//@Slf4j
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
// 어느 클래스를 가나 동일하다. 클래스 시작하면 항상 가지고 붙여 사용한다. println 대신 사용한다.
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		// info 레벨의 로그를 출력한다.
		//log.info("환영합니다. 지역은 {}", locale);
		
		logger.info("환영합니다. 지역은{}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formatterDate = dateFormat.format(date);
		
		model.addAttribute("서버 시간", formatterDate);
		
		logger.info("모델 정보:{},format:{}", model, formatterDate);
		System.out.println(model);
		
		return "home";
	}
}
