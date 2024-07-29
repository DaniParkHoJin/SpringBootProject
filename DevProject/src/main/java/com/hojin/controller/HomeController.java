package com.hojin.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.hojin.domin.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping(value = "/" )
	public String home(Locale locale, Model model) {
		
		log.info("환영합니다. 클라이언트 지역은 " + locale + "이다.");
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		Member member = new Member();
		member.setUserId("박호진");
		model.addAttribute("member",member);
		
		model.addAttribute("serverTime", formattedDate);
		
		return "home"; // 뷰 파일명
	}
	@GetMapping(value = "/welcome")
	public String welcome(Model model) {
		
		String[] args= {"박호진"};
		
		String message = messageSource.getMessage("welcome.message", args, Locale.KOREAN);
		
		log.info("Welcome message : " + message);
		model.addAttribute("message", message);
		return "welcome";
		
	}
}
