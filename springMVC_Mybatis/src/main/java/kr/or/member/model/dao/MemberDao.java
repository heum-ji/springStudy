package kr.or.member.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.member.model.vo.Member;
import kr.or.member.model.vo.MemberRowMapper;

@Repository
public class MemberDao {
	@Autowired
	private SqlSessionTemplate sqlSession;

	public MemberDao() {
		super();
	}

	// 로그인 / 아이디 찾기 / 아이디로 회원 조회
	public Member selectOneMember(Member m) {
		return sqlSession.selectOne("member.selectOneMember", m);
	}

	// 회원가입
	public int insertMember(Member m) {
		return sqlSession.insert("member.insertMember", m);
	}

	// 아이디 찾기
	public String searchId(Member m) {
		return sqlSession.selectOne("member.searchId", m);
	}

	// 비밀번호 찾기
	public List searchPw(Member m) {
		String query = "select * from member where member_id = ? and phone = ?";
		Object[] params = { m.getMemberId(), m.getPhone() };

		return jdbcTemplate.query(query, params, new MemberRowMapper());
	}

	// 회원 탈퇴
	public int deleteMember(String memberId) {
		return sqlSession.delete("member.deleteMember", memberId);
	}

	// 아이디로 회원 조회
	public List selectOneMember(String memberId) {
		String query = "select * from member where member_id = ?";
		Object[] params = { memberId };

		return jdbcTemplate.query(query, params, new MemberRowMapper());
	}

	// 회원정보 수정
	public int updateMemberInfo(Member m) {
		String query = "update member set phone = ?, address = ?, gender = ? where member_id = ?";
		Object[] params = { m.getPhone(), m.getAddress(), m.getGender(), m.getMemberId() };

		return jdbcTemplate.update(query, params);
	}

	// 전체 회원 조회
	public List selectAllMember() {
		String query = "select * from member";
		return jdbcTemplate.query(query, new MemberRowMapper());
	}

	// 전체 회원 수 조회
	public int selectAllMemberCount() {
		String query = "select count(*) from member";
		return jdbcTemplate.queryForObject(query, int.class);
	}

	// 비밀번호 확인
	public List checkPwMember(Member m) {
		String query = "select * from member where member_id = ? and member_pw = ?";
		Object[] params = { m.getMemberId(), m.getMemberPw() };

		return jdbcTemplate.query(query, params, new MemberRowMapper());
	}

	// 비밀번호 수정
	public int changePwMember(Member m) {
		String query = "update member set member_pw = ? where member_id = ?";
		Object[] params = { m.getMemberPw(), m.getMemberId() };

		return jdbcTemplate.update(query, params);
	}

}
