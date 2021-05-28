package kr.or.member.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.member.model.vo.Member;
import kr.or.member.model.vo.MemberRowMapper;

@Repository
public class MemberDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public MemberDao() {
		super();
		System.out.println("MemberDao 생성 완료");
	}

	// 로그인
	public List selectOneMember(Member m) {
		String query = "select * from member where member_id = ? and member_pw = ?";
		Object[] params = { m.getMemberId(), m.getMemberPw() };
		// 조회결과 갯수와 상관없이 무조건 list
		List list = jdbcTemplate.query(query, params, new MemberRowMapper());
		return list;
	}

	// 회원가입
	public int insertMember(Member m) {
		String query = "insert into member values(?, ?, ?, ?, ?, ?)";
		Object[] params = { m.getMemberId(), m.getMemberPw(), m.getMemberName(), m.getPhone(), m.getAddress(),
				m.getGender() };

		int result = jdbcTemplate.update(query, params);
		return result;
	}

	// 아이디 찾기
	public List searchId(Member m) {
		String query = "select * from member where member_name = ? and phone = ?";
		Object[] params = { m.getMemberName(), m.getPhone() };

		List list = jdbcTemplate.query(query, params, new MemberRowMapper());
		return list;
	}

	// 비밀번호 찾기
	public List searchPw(Member m) {
		String query = "select * from member where member_id = ? and phone = ?";
		Object[] params = { m.getMemberId(), m.getPhone() };

		List list = jdbcTemplate.query(query, params, new MemberRowMapper());
		return list;
	}

}
