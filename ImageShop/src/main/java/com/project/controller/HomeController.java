package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
public class HomeController {
    // 요구사항 정의 : 컨텍스트 후트 경로로 접근하면 홈 화면을 표시해야 한다.
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        Date date = new Date();

        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);
// 요구사항 정의 : 메시지를 프로퍼티 파일로 관리해야 한다.

        model.addAttribute("serverTime", formattedDate);

        return "home";
    }
}
