package kr.or.board.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.board.model.vo.Board;
import kr.or.board.model.vo.BoardRowMapper;
import kr.or.board.model.vo.FileTbl;
import kr.or.board.model.vo.FileTblRowMapper;

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

	// 게시판 목록 조회
	public List boardList() {
		String query = "select * from board order by board_no desc";
		return jdbcTemplate.query(query, new BoardRowMapper());
	}

	// 게시물 상세 조회
	public List selectOneBoard(int boardNo) {
		String query = "select * from board where board_no = ?";
		Object[] params = { boardNo };
		return jdbcTemplate.query(query, params, new BoardRowMapper());
	}

	// 첨부파일 조회
	public List selectFileInfo(int boardNo) {
		String query = "select * from file_tbl where board_no = ?";
		Object[] params = { boardNo };

		return jdbcTemplate.query(query, params, new FileTblRowMapper());
	}
}
