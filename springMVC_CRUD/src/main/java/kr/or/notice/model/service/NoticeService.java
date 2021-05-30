package kr.or.notice.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.notice.model.dao.NoticeDao;
import kr.or.notice.model.vo.Notice;

@Service
public class NoticeService {
	@Autowired
	private NoticeDao dao;

	// 전체 공지사항 조회
	public List selectAllNotice() {
		return dao.selectAllNotice();
	}

	// 공지사항 상세보기
	public Notice selectOneNotice(int noticeNo) {
		List list = dao.selectOneNotice(noticeNo);
		Notice notice = null;

		if (!list.isEmpty()) {
			notice = (Notice) list.get(0);
		}
		return notice;
	}

	// 공지사항 작성
	public int insertNotice(Notice n) {
		return dao.insertNotice(n);
	}

	// 공지사항 수정
	public int updateNotice(Notice n) {
		return dao.updateNotice(n);
	}

	// 공지사항 삭제
	public int deleteNotice(int noticeNo) {
		return dao.deleteNotice(noticeNo);
	}

}