package kr.or.member.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.member.model.dao.MemberDao;
import kr.or.member.model.vo.Member;

@Service
public class MemberService {
	@Autowired
	private MemberDao dao;

	// 로그인
	public Member selectOneMember(Member m) {
		return dao.selectOneMember(m);
	}

	// 회원가입
	@Transactional
	public int insertMember(Member m) {
		return dao.insertMember(m);
	}

	// 아이디 찾기
	public Member searchId(Member m) {
		return dao.searchId(m);
	}

	// 비밀번호 찾기
	public Member searchPw(Member m) {
		return dao.searchPw(m);
	}

	// 회원 탈퇴
	@Transactional
	public int deleteMember(String memberId) {
		return dao.deleteMember(memberId);
	}

	// 회원정보 수정
	@Transactional
	public int updateMemberInfo(Member m) {
		return dao.updateMemberInfo(m);
	}

	// 전체 회원 조회
	public List selectAllMember() {
		return dao.selectAllMember();
	}

	// 전체 회원 수 조회
	public int selectAllMemberCount() {
		return dao.selectAllMemberCount();
	}

	// 비밀번호 수정
	@Transactional
	public int changePwMember(Member m) {
		return dao.changePwMember(m);
	}

	// 내 쿠폰 확인
	public List selectAllCoupon(Member m) {
		return dao.selectAllCoupon(m);
	}

	// 쿠폰 만료 처리
	public int expireCoupon() {
		return dao.expireCoupon();
	}

}
