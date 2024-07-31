package com.hojin.service;

import com.hojin.dao.BoardDAO;
import com.hojin.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BoardServiceImpl implements BoardService {


    private BoardDAO dao;

    @Autowired
    public void setDao(BoardDAO dao) {
        this.dao = dao;
    }
    @Override
    public void register(Board board) throws Exception {
        dao.create(board);
    }

    @Override
    public Board read(Integer boardNo) throws Exception {
        return null;
    }

    @Override
    public void modify(Board board) throws Exception {

    }

    @Override
    public void remove(Integer boardNo) throws Exception {

    }

    @Override
    public List<Board> list() throws Exception {
        return dao.list();

        
    }
}
