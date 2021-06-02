package kr.or.board.model.vo;

import java.util.List;

import lombok.Data;

@Data
public class Board {
	private int boardNo;
	private String boardTitle;
	private String boardWriter;
	private String boardContent;
	private String boardDate;
	private List<FileTbl> fileList;
	
	public String getBoardContentBr() {
		return boardContent.replaceAll("\r\n", "<br>");
	}
}