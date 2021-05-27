package kr.or.member.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchMember implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 1. 인코딩
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// 2. 값 추출
		String memberId = request.getParameter("memberId");
		// 3. 비지니스 로직 및 결과처리(MemberService를 호출하는 로직이지만 편의상 user01인지만 확인)
		if (memberId.equals("user01")) {
			return "searchSuccess"; // 조회 성공 시 보여줄 jsp 파일 이름
		} else {
			return "searchFail"; // 조회 실패 시 보여줄 jsp 파일 이름
		}
	}
}
