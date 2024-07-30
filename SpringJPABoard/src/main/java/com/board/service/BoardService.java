package com.board.service;

import com.board.domain.Board;

import java.util.List;

public interface BoardService {
    public void register(Board board) throws Exception;

    public Board read(Long boardNo) throws Exception;

    public void update(Board board) throws Exception;

    public void delete(Long boardNo) throws Exception;

    public List<Board> list() throws Exception;

}
