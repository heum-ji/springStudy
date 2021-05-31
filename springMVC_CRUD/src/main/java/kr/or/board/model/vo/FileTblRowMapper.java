package kr.or.board.model.vo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class FileTblRowMapper implements RowMapper {
	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		FileTbl ft = new FileTbl();
		
		ft.setBoardNo(rs.getInt("board_no"));
		ft.setFilename(rs.getString("filename"));
		ft.setFileNo(rs.getInt("file_no"));
		ft.setFilepath(rs.getString("filepath"));
		
		return ft;
	}
}
