package kr.or.board.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.board.model.vo.Board;
import kr.or.board.model.vo.FileTbl;

@Repository
public class BoardDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// 글쓰기
	public int insertBoard(Board b) {
		String query = "insert into board values(board_seq.nextval, ?, ?, ?, to_char(sysdate, 'yyyy-mm-dd'))";
		Object[] params = { b.getBoardTitle(), b.getBoardWriter(), b.getBoardContent() };

		return jdbcTemplate.update(query, params);
	}

	// 최신 글번호 조회
	public int selectBoardNo() {
		String query = "select max(board_no) from board"; // 가장 최신글 조회

		return jdbcTemplate.queryForObject(query, int.class);
	}

	// 파일 업로드 db 저장
	public int insertFile(FileTbl f) {
		String query = "insert into file_tbl values(file_seq.nextval, ?, ?, ?)";
		Object[] params = { f.getFilename(), f.getFilepath(), f.getBoardNo() };

		return jdbcTemplate.update(query, params);
	}
}
