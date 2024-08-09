package com.project.controller;

import com.project.common.security.domain.CustomUser;
import com.project.domain.Board;
import com.project.domain.Member;
import com.project.domain.PageRequest;
import com.project.domain.Pagination;
import com.project.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board")
@Slf4j
public class BoardController {

    @Autowired
    private BoardService service;

    // 게시글 등록 페이지
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public void registerForm(Model model, Authentication authentication) throws Exception {
        // 로그인한 사용자 정보 획득
        CustomUser customUser = (CustomUser) authentication.getPrincipal();
        Member member = customUser.getMember();

        Board board = new Board();
        //로그인한 사용자 아이디를 등록 페이지에 표현
        board.setWriter(member.getUserId());

        model.addAttribute(board);
    }

    // 게시들 등록 처리
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public String register(Board board, RedirectAttributes rttr) throws Exception {
        service.register(board);

        rttr.addFlashAttribute("msg", "SUCCESS");
        return "redirect:/board/list";
    }

//    // 게시글 목록 페이지
//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    public void list(Model model) throws Exception{
//        model.addAttribute("list", service.list());// jsp에 넘기는 이름과 같아야 한다.
//    }

    // 페이징 요청 정보를 매개 변수로 받고 다시 뷰에 전달한다.
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public void list(@ModelAttribute("pgrq") PageRequest pageRequest, Model
            model) throws Exception {
        // 뷰에 페이징 처리를 한 게시글 목록을 전달한다.
        model.addAttribute("list", service.list(pageRequest));
        // 페이징 네비게이션 정보를 뷰에 전달한다.
        Pagination pagination = new Pagination();

        pagination.setPageRequest(pageRequest);
        pagination.setTotalCount(service.count());
        model.addAttribute("pagination", pagination);
    }

    // 게시글 상세 페이지, 페이징 요청 정보를 매개변수로 받고 다시 뷰에 전달한다
    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public void read(int boardNo, @ModelAttribute("pgrq") PageRequest pageRequest, Model model) throws Exception {
        // 조회한 게시글 상세 정보를 뷰에 전당한다.
        Board board = service.read(boardNo);

        model.addAttribute(board);
    }

    // 게시글 수정 페이지, 페이징 요청 정보를 매개변수로 받고 다시 뷰에 전달한다.
    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MEMBER')")
    public void modifyForm(int boardNo, @ModelAttribute("pgrq") PageRequest
            pageRequest, Model model) throws Exception {
        // 조회한 게시글 상세 정보를 뷰에 전달한다.
        Board board = service.read(boardNo);
        model.addAttribute(board);
    }

    // 게시글 수정 처리, 페이징 요청 정보를 매개변수로 받고 다시 뷰에 전달한다.
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MEMBER')")
    public String modify(Board board, PageRequest pageRequest,
                         RedirectAttributes rttr) throws Exception {
        service.modify(board);
// RedirectAttributes 객체에 일회성 데이터를 지정하여 전달한다.
        rttr.addAttribute("page", pageRequest.getPage());
        rttr.addAttribute("sizePerPage", pageRequest.getSizePerPage());
        rttr.addFlashAttribute("msg", "SUCCESS");
        return "redirect:/board/list";
    }

//
//    // 게시글 상세 페이지
//    @RequestMapping(value = "/read/{boardNo}", method = RequestMethod.GET)
//    public String read(@PathVariable int boardNo, Model model) throws Exception {
//
//        model.addAttribute(service.read(boardNo));
//
//        return "board/read";
//    }

//    // 게시글 수정 페이지
//    @RequestMapping(value = "/modify/{boardNo}", method = RequestMethod.GET)
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MEMBER')")
//    public String modifyForm(@PathVariable int boardNo, Model model) throws Exception {
//        model.addAttribute(service.read(boardNo));
//
//        return "board/modify";
//    }

//    // 게시글 수정 처리
//    @RequestMapping(value = "/modify", method = RequestMethod.POST)
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MEMBER')")
//    public String modify(Board board, RedirectAttributes rttr) throws Exception {
//
//        service.modify(board);
//
//        rttr.addFlashAttribute("msg", "SUCCESS");
//
//        return "redirect:/board/list";

//}

    // 게시글 삭제 처리
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String delete(int boardNo, PageRequest pageRequest,
                         RedirectAttributes rttr) throws Exception {
        service.delete(boardNo);
        // RedirectAttributes 객체에 일회성 데이터를 지정하여 전달한다.
        rttr.addAttribute("page", pageRequest.getPage());
        rttr.addAttribute("sizePerPage", pageRequest.getSizePerPage());
        rttr.addFlashAttribute("msg", "SUCCESS");
        return "redirect:/board/list";
    }
}
