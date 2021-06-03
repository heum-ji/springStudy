package kr.or.board.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.board.model.vo.Board;
import kr.or.board.model.vo.FileTbl;

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

	// 게시판 상세 조회
	public Board selectOneBoard(int boardNo) {
		return sqlSession.selectOne("board.selectOneBoard", boardNo);
	}
}
