package com.hojin.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hojin.domin.Address;
import com.hojin.domin.Card;
import com.hojin.domin.FileMember;
import com.hojin.domin.Member;
import com.hojin.domin.MultiFileMember;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController {
	@GetMapping(value = "/registerModelForm")
	public String registerModelForm() {
		log.info("registerModelForm");
		return "registerModelForm";
	}

	@PostMapping(value = "/registerModelForm01")
	public String registerModelForm01(String userId) {
		log.info("registerModelForm01");

		log.info("userId = " + userId);
		return "registerModelForm01";
	}

	@PostMapping(value = "/registerModelForm02")
	public String registerModelForm02(@ModelAttribute("userId") String userId) {
		log.info("registerModelForm02");
		log.info("userId = " + userId);

		return "registerModelForm02";
	}

	@PostMapping(value = "/registerModelForm03")
	public String registerModelForm03(@ModelAttribute("userId") String userId,
			@ModelAttribute("password") String password) {
		log.info("registerModelForm03");

		log.info("userId = " + userId);
		log.info("password = " + password);

		return "registerModelForm03";
	}

	@PostMapping(value = "/registerModelForm04")
	public String registerModelForm04(Member member) {
		log.info("registerModelForm04");

		log.info("userId = " + member.getUserId());
		log.info("password = " + member.getPassword());

		return "registerModelForm04";

	}

	@GetMapping(value = "/registerRedirectAttributesForm")
	public String registerRedirectAttributesForm() {
		log.info("registerRedirectAttributesForm");
		return "registerRedirectAttributesForm"; // 뷰 파일명
	}

	@PostMapping(value = "/registerRedirectAttributes")
	public String registerRedirectAttributes(Member member, RedirectAttributes rttr) throws Exception {
		log.info("registerRedirectAttributes");
		rttr.addFlashAttribute("msg", "success");
		return "redirect:/result"; // 연결 뷰 파일명
	}

	@GetMapping(value = "/result")
	public String result() {
		log.info("result");
		return "result"; // 뷰 파일명
	}

}
