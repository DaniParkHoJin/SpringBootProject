package com.hojin.controller;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Log
@RequestMapping("/notice")
@Controller
public class NoticeController {

    @RequestMapping("/list")
    public void list() {
        log.info("list : 모두가 접근 가능");
    }

    @RequestMapping("/register")
    public void registerForm() {
        log.info("registerForm : 로그인한 관리자만 접근 가능");
    }
}
