package kr.or.member.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.member.model.dao.MemberDao;
import kr.or.member.model.vo.Member;

@Service
public class MemberService {
	@Autowired
	private MemberDao dao;

	public MemberService() {
		super();
	}

	// 로그인 / 아이디 찾기 / 아이디로 회원 찾기
	public Member selectOneMember(Member m) {
		return dao.selectOneMember(m);
	}

	// 회원가입
	public int insertMember(Member m) {
		return dao.insertMember(m);
	}

	// 아이디 찾기
	public String searchId(Member m) {
		return dao.searchId(m);
	}

	// 비밀번호 찾기
	public Member searchPw(Member m) {
		List list = dao.searchPw(m);
		Member member = null;

		if (!list.isEmpty()) {
			member = (Member) list.get(0);
		}
		return member;
	}

	// 회원 탈퇴
	public int deleteMember(String memberId) {
		return dao.deleteMember(memberId);
	}

	// 아이디로 회원 조회
	public Member selectOneMember(String memberId) {
		List list = dao.selectOneMember(memberId);
		Member member = null;

		if (!list.isEmpty()) {
			member = (Member) list.get(0);
		}
		return member;
	}

	// 회원정보 수정
	public int updateMemberInfo(Member m) {
		int result = dao.updateMemberInfo(m);
		return result;
	}

	// 전체 회원 조회
	public List selectAllMember() {
		List list = dao.selectAllMember();
		return list;
	}

	// 전체 회원 수 조회
	public int selectAllMemberCount() {
		int result = dao.selectAllMemberCount();
		return result;
	}

	// 비밀번호 확인
	public Member checkPwMember(Member m) {
		List list = dao.checkPwMember(m);
		Member member = null;

		if (!list.isEmpty()) {
			member = (Member) list.get(0);
		}
		return member;
	}

	// 비밀번호 수정
	public int changePwMember(Member m) {
		return dao.changePwMember(m);
	}

}
