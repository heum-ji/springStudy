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
		System.out.println("MemberService 생성완료");
	}

	// 로그인
	public Member selectOneMember(Member m) {
		List list = dao.selectOneMember(m);
		Member member = null;
		
		if (!list.isEmpty()) {
			member = (Member) list.get(0);
		}
		return member;
	}

	// 회원가입
	public int insertMember(Member m) {
		return dao.insertMember(m);
	}

	// 아이디 찾기
	public Member searchId(Member m) {
		List list = dao.searchId(m);
		Member member = null;
		
		if (!list.isEmpty()) {
			member = (Member) list.get(0);
		}
		return member;
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

}
