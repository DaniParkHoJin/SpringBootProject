package com.hojin.comtroller;

import com.hojin.domain.Board;
import com.hojin.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {


    private BoardService boardService;

    @Autowired
    public void setBoard(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/register")
    public void regitserForm(Board board, Model model){
    log.info("/board/regitser");
    }

    @PostMapping("/register")
    public String register(Board board, Model model) throws Exception{

        boardService.register(board);
        model.addAttribute("msg", "게시글 등록에 성공 하였습니다.");

        return "/board/success";
    }

    @GetMapping("/list")
    public String list(Model model) throws Exception {

        model.addAttribute("boardList", boardService.list());

        return "/board/list";
    }
}
