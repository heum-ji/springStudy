package kr.or.board.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
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
	private SqlSessionTemplate sqlSession;

	// 글쓰기
	public int insertBoard(Board b) {
		return sqlSession.insert("board.insertBoard", b);
	}

	// 최신 글번호 조회
	public int selectBoardNo() {
		return sqlSession.selectOne("board.selectBoardNo");
	}

	// 파일 업로드 db 저장
	public int insertFile(FileTbl f) {
		return sqlSession.insert("board.insertFile", f);
	}

	// 게시판 목록 조회
	public List boardList() {
		return sqlSession.selectList("board.boardList");
	}
//
//	// 게시물 상세 조회
//	public List selectOneBoard(int boardNo) {
//		String query = "select * from board where board_no = ?";
//		Object[] params = { boardNo };
//		return jdbcTemplate.query(query, params, new BoardRowMapper());
//	}
//
//	// 첨부파일 조회
//	public List selectFileInfo(int boardNo) {
//		String query = "select * from file_tbl where board_no = ?";
//		Object[] params = { boardNo };
//
//		return jdbcTemplate.query(query, params, new FileTblRowMapper());
//	}
}
