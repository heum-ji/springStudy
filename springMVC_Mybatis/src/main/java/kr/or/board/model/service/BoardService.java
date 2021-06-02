package kr.or.board.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.board.model.dao.BoardDao;
import kr.or.board.model.vo.Board;
import kr.or.board.model.vo.FileTbl;

@Service
public class BoardService {
	@Autowired
	private BoardDao dao;

	// 글 쓰기 - 다중 파일 업로드
	public int insertBoard(Board b, ArrayList<FileTbl> fileList) {
		// 파일 db는 board_no가 외래키로 걸려 있기 때문에, Board에 글쓰기 부터 해야 함
		int result1 = dao.insertBoard(b); // 글쓰기 결과
		int result = 0; // 최종 리턴 값

		if (result1 > 0) { // 글쓰기 성공 시
			int boardNo = dao.selectBoardNo(); // 가장 최신 글번호 조회

			for (FileTbl f : fileList) {
				f.setBoardNo(boardNo); // 가장 최신 글번호 설정
				result += dao.insertFile(f); // 파일 업로드 성공 시 result + 1 -> 최종적으로 완료 시 fileList.size() == result
			}
		} else {
			return -1;
		}
		return result;
	}

	// 게시판 목록 조회
	public List boardList() {
		return dao.boardList();
	}
//
//	// 게시물 상세 조회
//	public Board selectOneBoard(int boardNo) {
//		// 게시물 정보 조회
//		List list = dao.selectOneBoard(boardNo);
//		Board b = null;
//
//		// 게시물 정보 삽입
//		if (!list.isEmpty()) {
//			b = (Board) list.get(0);
//		}
//
//		// 첨부파일 정보 조회
//		if (b != null) {
//			List fileList = dao.selectFileInfo(boardNo);
//
//			if (!fileList.isEmpty()) {
//				b.setFileList(fileList); // 첨부파일 정보 삽입
//			}
//		}
//		return b;
//	}
}
