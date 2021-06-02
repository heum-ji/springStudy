package kr.or.member.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.member.model.vo.Member;

@Repository
public class MemberDao {
	@Autowired
	private SqlSessionTemplate sqlSession;

	// 로그인
	public Member selectOneMember(Member m) {
		return sqlSession.selectOne("member.selectOneMember", m);
	}

	// 회원가입
	public int insertMember(Member m) {
		return sqlSession.insert("member.insertMember", m);
	}

	// 아이디 찾기
	public Member searchId(Member m) {
		return sqlSession.selectOne("member.searchId", m);
	}

	// 비밀번호 찾기
	public Member searchPw(Member m) {
		return sqlSession.selectOne("member.searchPw", m);
	}

	// 회원 탈퇴
	public int deleteMember(String memberId) {
		return sqlSession.delete("member.deleteMember", memberId);
	}

	// 아이디로 회원 조회
	public Member selectOneMemberId(String memberId) {
		return sqlSession.selectOne("member.selectOneMemberId", memberId);
	}

	// 회원정보 수정
	public int updateMemberInfo(Member m) {
		return sqlSession.update("member.updateMemberInfo", m);
	}

	// 전체 회원 조회
	public List selectAllMember() {
		return sqlSession.selectList("member.selectAllMember");
	}

	// 전체 회원 수 조회
	public int selectAllMemberCount() {
		return sqlSession.selectOne("member.selectAllMemberCount");
	}

	// 비밀번호 수정
	public int changePwMember(Member m) {
		return sqlSession.update("member.changePwMember", m);
	}

}
