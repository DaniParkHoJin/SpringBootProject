package com.hojin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hojin.domin.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController {

	@RequestMapping(value = "/registerForm", method = RequestMethod.GET)
	public String registerForm() {
		log.debug("registerForm");
		return "registerForm";
	}

	@RequestMapping(value = "/register/{userId}", method = RequestMethod.GET)
	public String registerByPath(@PathVariable("userId") String userId) {
		log.info("registerByPath : /register/{userId} ");
		log.info("userId = " + userId);
		return "success";
	}

	@RequestMapping(value = "/register/{userId}/{coin}", method = RequestMethod.GET)
	public String registerByPath(@PathVariable("userId") String userId, @PathVariable("coin") int coin) {
		log.info("registerByPath : /register/{userId}/{coin}");
		log.info("userId = " + userId);
		log.info("coin = " + coin);
		return "success";
	}

	@RequestMapping(value = "/register01", method = RequestMethod.POST)
	public String register01(String userId) {
		log.info("register01 : userId");
		log.info("userId = " + userId);
		return "success";
	}

	@RequestMapping(value = "/register02", method = RequestMethod.POST)
	public String register02(@RequestParam("userId") String username) {
		log.info("register02 : @RequestParam");
		log.info("userId = " + username);
		return "success";
	}

}
