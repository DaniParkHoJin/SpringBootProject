package com.hojin;

import java.util.Date;
import com.hojin.domin.Board;
import com.hojin.service.BoardService;

public class LombokApplication {
	public static void main(String[] args) {
		BoardService boardService = new BoardService();
		
		Board board = Board.builder()
				.boardNo(1)
				.title("Builder, Slf4j 테스트")
				.content("@Builder, @Slf4j 에너테이션")
				.regDate(new Date()).build();
		boardService.create(board);
		boardService.readByBoardNo(1);
		boardService.delete(board);
	}
}
