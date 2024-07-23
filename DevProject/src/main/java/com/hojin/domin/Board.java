package com.hojin.domin;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 롬복

@Data
@Builder
//클래스는 직렬화되어야 한다.
public class Board {
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private Date regDate;

//	// 기본 생성자
//	public Board() {
//		super();
//	}
//
//	public Board(int boardNo, String title) {
//		super();
//		this.boardNo = boardNo;
//		this.title = title;
//	}
//
//	public int getBoardNo() {
//		return boardNo;
//	}
//
//	public void setBoardNo(int boardNo) {
//		this.boardNo = boardNo;
//	}
//
//	public String getTitle() {
//		return title;
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//	public String getContent() {
//		return content;
//	}
//
//	public void setContent(String content) {
//		this.content = content;
//	}
//
//	public String getWriter() {
//		return writer;
//	}
//
//	public void setWriter(String writer) {
//		this.writer = writer;
//	}
//
//	public Date getRegDate() {
//		return regDate;
//	}
//
//	public void setRegDate(Date regDate) {
//		this.regDate = regDate;
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + boardNo;
//		return result;
//
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj) return true;
//		if (obj == null) return false;
//		if (getClass() != obj.getClass()) return false;
//		Board other = (Board) obj;
//		if (boardNo != other.boardNo) return false;
//		return true;
//			
//	}
//
//	@Override
//	public String toString() {
//		return "Board [boardNo=" + boardNo + ", title=" + title + ", content=" + content + ", writer=" + writer
//				+ ", regDate=" + regDate + "]";
//	}

}
