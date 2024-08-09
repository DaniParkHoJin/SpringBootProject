package com.project.service;

import com.project.domain.Board;
import com.project.domain.PageRequest;
import com.project.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper mapper;
    // 게시글 등록 처리
    @Override
    public void register(Board board) throws Exception {
        mapper.create(board);
    }
//    // 게시글 목록 페이지
//    @Override
//    public List<Board> list() throws Exception {
//        return mapper.list();
//    }

    // 페이징 요청 정보를 매개 변수로 받아 페이징 처리를 한 게시글 목록을 반환한다.
    @Override
    public List<Board> list(PageRequest pageRequest) throws Exception {
        return mapper.list(pageRequest);

    }

    @Override
    public Board read(Integer boardNo) throws Exception {
        return mapper.read(boardNo);
    }

    @Override
    public void modify(Board board) throws Exception {
        mapper.modify(board);
    }

    @Override
    public void delete(Integer boardNo) throws Exception {
            mapper.delete(boardNo);
    }

    @Override
    public int count() throws Exception {
        return mapper.count();
    }
}
