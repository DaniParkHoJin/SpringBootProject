package com.hojin.common.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class CommonExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public String handle(Exception ex, Model model) {
		log.info(ex.toString());
		model.addAttribute("exception", ex);

		return "error/common";
		
		
	}
}