package com.hojin.controller;

import com.hojin.domain.Member;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Log
@Controller
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm() {
        log.info("loginForm");
        return "loginForm";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String userId, String userPw, Model model) {
        log.info("login");
        log.info("login userId = " + userId);
        log.info("login userPw = " + userPw);

        Member member = new Member();

        member.setUserId(userId);
        member.setUserPw(userPw);
        member.setUserName("박호진");
        member.setEmail("parkhojin@naver.com");

        model.addAttribute("user", member);

        model.addAttribute("result", "로그인 되었습니다.");
        return "success";
    }



}
