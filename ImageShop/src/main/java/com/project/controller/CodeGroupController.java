package com.project.controller;

import com.project.domain.CodeGroup;
import com.project.service.CodeGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/codegroup")
public class CodeGroupController {
    @Autowired
    private CodeGroupService service;

    // 등록 페이지
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public void registerForm(Model model) {
        CodeGroup codeGroup = new CodeGroup();

        model.addAttribute(codeGroup);
    }

    // 등록처리

     public String register(CodeGroup codeGroup, RedirectAttributes rttr) throws  Exception{

        service.register(codeGroup);
        rttr.addAttribute("msg", "SUCCESS");

        return "redirect:/codegroup/list";
     }
}
