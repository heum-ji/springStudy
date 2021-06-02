package kr.or.notice.model.vo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class NoticeRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Notice n = new Notice();
		n.setNoticeContent(rs.getString("notice_content"));
		n.setNoticeDate(rs.getString("notice_date"));
		n.setNoticeNo(rs.getInt("notice_no"));
		n.setNoticeTitle(rs.getString("notice_title"));
		n.setNoticeWriter(rs.getString("notice_writer"));

		return n;
	}
}
