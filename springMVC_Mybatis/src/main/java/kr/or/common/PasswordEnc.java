package kr.or.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.member.model.vo.Member;

@Service
@Aspect
public class PasswordEnc {
	@Autowired
	private SHA256Enc enc;

	// MemberService에서 메서드명이 Member로 끝나면서 매개변수가 Member 타입인 메서드
	// 로그인 / 회원가입 시 Pointcut 지정
	@Pointcut("execution (* kr.or.member.model.service.MemberService.*Member(kr.or.member.model.vo.Member))")
	public void encPointcut() {
	}

	// 로그인 / 회원가입 전
	@Before("encPointcut()")
	public void encPass(JoinPoint jp) throws Exception {
		String methodName = jp.getSignature().getName();
		Object[] args = jp.getArgs();

		Member m = (Member) args[0]; // 매개변수 추출

		if (m.getMemberPw() != null) {
			String passwd = m.getMemberPw(); // 비번 추출
			String encPw = enc.encData(passwd); // 비번 암호화

			m.setMemberPw(encPw); // 암호화된 비번 설정
			System.out.println(methodName + " 메서드에서 암호화 시전");
		}
	}
}
