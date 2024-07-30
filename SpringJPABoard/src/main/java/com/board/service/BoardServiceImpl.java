package com.board.service;

import com.board.domain.Board;
import com.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository repository;

    @Override
    @Transactional
    public void register(Board board) throws Exception{
        repository.save(board);
    }

    @Override
    @Transactional(readOnly = true)
    public Board read(Long boardNo) throws Exception {
        return repository.getOne(boardNo);
    }

    @Override
    @Transactional
    public void update(Board board) throws Exception {
    Board boardEntity = repository.getOne(board.getBoardNo());

    boardEntity.setTitle(board.getTitle());
    boardEntity.setContent(board.getContent());
    }

    @Override
    @Transactional
    public void delete(Long boardNo) throws Exception {
    repository.deleteById(boardNo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Board> list() throws Exception {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "boardNo"));
    }
}
