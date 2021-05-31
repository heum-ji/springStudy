package kr.or.board.model.vo;

import lombok.Data;

@Data
public class Board {
	private int boardNo;
	private String boardTitle;
	private String boardWriter;
	private String boardContent;
	private String boardDate;
}