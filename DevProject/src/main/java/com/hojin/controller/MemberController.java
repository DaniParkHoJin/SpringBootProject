package com.hojin.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hojin.domin.Address;
import com.hojin.domin.Card;
import com.hojin.domin.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController {
	// 입력값 검증을 할 도메인 클래스에 @Vaildated를 지정한다.
	@RequestMapping(value = "/registerValidation2", method = RequestMethod.POST)
	public String registerValidation2(@Validated Member member, BindingResult result) {
		log.info("registerValidation2");
		// 입력값 검증 에러가 발생한 경우 true를 반환한다.
		log.info("result.hasErrors() = " + result.hasErrors());
		// 입력값 검증 후 BindingResult가 제공하는 메서드를 이용하여 검사 결과를 확인한다.
		if (result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors();
			List<ObjectError> globalErrors = result.getGlobalErrors();
			List<FieldError> fieldErrors = result.getFieldErrors();
			log.info("allErrors.size() = " + allErrors.size());
			log.info("globalErrors.size() = " + globalErrors.size());
			log.info("fieldErrors.size() = " + fieldErrors.size());
			for (int i = 0; i < allErrors.size(); i++) {
				ObjectError objectError = allErrors.get(i);
				log.info("allError = " + objectError);
			}
			for (int i = 0; i < globalErrors.size(); i++) {
				ObjectError objectError = globalErrors.get(i);
				log.info("globalError = " + objectError);
			}
			for (int i = 0; i < fieldErrors.size(); i++) {
				FieldError fieldError = fieldErrors.get(i);
				log.info("fieldError = " + fieldError);
				log.info("fieldError.getDefaultMessage() = " + fieldError.getDefaultMessage());
			}
			return "registerValidation2Form"; // 뷰 파일명
		}
		log.info("member.getUserId() = " + member.getUserId());
		log.info("member.getGender() = " + member.getGender());
		return "success";
	}

	@RequestMapping(value = "/registerValidation2Form01", method = RequestMethod.GET)
	public String registerValidation2Form01(Model model) {
		log.info("registerValidation2Form01");
		model.addAttribute("member", new Member());
		return "registerValidation2Form"; // 뷰 파일명
	}

	@RequestMapping(value = "/registerValidation2Form02", method = RequestMethod.GET)
	public String registerValidation2Form02(Model model) {
		log.info("registerValidation2Form02");
		Member member = new Member();
		member.setPassword("1234");
		member.setEmail("aaa@ccc.com");
		member.setUserName("홍길동");
		member.setGender("female");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1988);
		cal.set(Calendar.MONTH, 10);
		cal.set(Calendar.DAY_OF_MONTH, 7);
		member.setDateOfBirth(cal.getTime());
		model.addAttribute("member", member);
		return "registerValidation2Form"; // 뷰 파일명
	}
}