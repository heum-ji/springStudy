package kr.or.notice.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.notice.model.vo.NoticeRowMapper;

@Repository
public class NoticeDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// 전체 공지 조회
	public List selectAllNotice() {
		String query = "select * from notice";
		return jdbcTemplate.query(query, new NoticeRowMapper());
	}

	public List selectOneNotice(int noticeNo) {
		String query = "select * from notice where notice_no = ?";
		Object[] params = { noticeNo };
		return jdbcTemplate.query(query, params, new NoticeRowMapper());
	}
	

}
