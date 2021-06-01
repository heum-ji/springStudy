package kr.or.common;

import org.aspectj.lang.JoinPoint;

public class BeforeAdvice {

	public void beforeLog(JoinPoint jp) {
		String methodName = jp.getSignature().getName(); // 호출된 비지니스 메서드 이름 가져오기
		Object[] args = jp.getArgs(); // 매개변수 가져오기
		
		System.out.println("[사전처리] " + methodName + " / 매개변수 정보 : " + args[0].toString());
	}
}
