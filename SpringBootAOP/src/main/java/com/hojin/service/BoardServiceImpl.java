package com.hojin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hojin.domain.Board;
import com.hojin.exception.BoardRecordNotFoundException;
import com.hojin.mapper.BoardMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper mapper;

	@Override
	public void register(Board board) throws Exception {
		log.info("register");
		mapper.create(board);
	}

	@Override
	public Board read(Integer boardNo) throws Exception {
		log.info("read");
		Board board = mapper.read(boardNo);

		// 게시글이 존재하지 않으면 정의한 예외를 발생시킨다.
		if (board == null) {
			throw new BoardRecordNotFoundException(boardNo + " 번 게시글은 없는 게시글입니다.");
		}

		return board;
	}

	@Override
	public void modify(Board board) throws Exception {
		log.info("modify");
		mapper.update(board);
	}

	@Override
	public void remove(Integer boardNo) throws Exception {
		log.info("remove");
		mapper.delete(boardNo);
	}

	@Override
	public List<Board> list() throws Exception {
		log.info("list");
		return mapper.list();
	}
}
