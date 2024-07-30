package com.board.service;

import com.board.domain.Board;

import java.util.List;


public interface BoardService {

    // 등록 서비스
    public void register(Board board) throws Exception;
    // 목록 서비스
    public List<Board> list() throws Exception;
    // 상세 화면
    public Board read(Integer boardNo) throws Exception;


    public void modify(Board board) throws Exception;
    //삭제  서비스
    public void remove(Integer boardNo) throws Exception;
}
