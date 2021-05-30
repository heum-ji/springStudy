package kr.or.notice.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.notice.model.vo.Notice;
import kr.or.notice.model.vo.NoticeRowMapper;

@Repository
public class NoticeDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// 전체 공지 조회
	public List selectAllNotice() {
		String query = "select * from notice order by notice_no desc";

		return jdbcTemplate.query(query, new NoticeRowMapper());
	}

	// 공지사항 상세보기
	public List selectOneNotice(int noticeNo) {
		String query = "select * from notice where notice_no = ?";
		Object[] params = { noticeNo };

		return jdbcTemplate.query(query, params, new NoticeRowMapper());
	}

	// 공지사항 작성
	public int insertNotice(Notice n) {
		String query = "insert into notice values(NOTICE_SEQ.NEXTVAL, ?, ?, ?, to_char(sysdate, 'yyyy-mm-dd'))";
		Object[] params = { n.getNoticeTitle(), n.getNoticeContent(), n.getNoticeWriter() };

		return jdbcTemplate.update(query, params);
	}

	// 공지사항 수정
	public int updateNotice(Notice n) {
		String query = "update notice set notice_title = ?, notice_content = ? where notice_no = ?";
		Object[] params = { n.getNoticeTitle(), n.getNoticeContent(), n.getNoticeNo() };

		return jdbcTemplate.update(query, params);
	}

	// 공지사항 삭제
	public int deleteNotice(int noticeNo) {
		String query = "delete from notice where notice_no = ?";
		return jdbcTemplate.update(query, noticeNo);
	}

}