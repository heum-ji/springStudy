package kr.or.member.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import kr.or.member.model.service.MemberService;
import kr.or.member.model.vo.Member;

@Controller
public class MemberController {
	@Autowired
	private MemberService service;

	@RequestMapping(value = "/login.do")
	public String login(Member m, HttpSession session, Model model) {
		Member member = service.selectOneMember(m);

		if (member != null) {
			session.setAttribute("m", member);
			model.addAttribute("msg", "로그인 성공");
		} else {
			model.addAttribute("msg", "아이디 또는 비밀번호를 확인해주세요.");
		}
		model.addAttribute("loc", "/");
		return "common/msg";
	}

	@RequestMapping(value = "/joinFrm.do")
	public String joinFrm() {
		return "member/joinFrm";
	}

	@RequestMapping(value = "/join.do")
	public String join(Member m, Model model) {
		int result = service.insertMember(m);

		if (result > 0) {
			model.addAttribute("msg", "회원가입 성공");
		} else {
			model.addAttribute("msg", "회원가입 실패");
		}
		model.addAttribute("loc", "/");
		return "common/msg";
	}

	@RequestMapping(value = "/searchFrm.do")
	public String searchFrm() {
		// /WEB-INF/views/ xx.jsp
		return "member/searchFrm";
	}

	@RequestMapping(value = "/idSearch.do")
	public String idSearch(Member m, Model model) {
		Member member = service.searchId(m);

		if (member != null) {
			model.addAttribute("msg", "아이디는 [ " + member.getMemberId() + " ] 입니다.");
		} else {
			model.addAttribute("msg", "정보를 조회할 수 없습니다.");
		}
		model.addAttribute("loc", "/");
		return "common/msg";
	}

	@RequestMapping(value = "/pwSearch.do")
	public String pwSearch(Member m, Model model) {
		Member member = service.searchPw(m);

		if (member != null) {
			model.addAttribute("msg", "비밀번호는 [ " + member.getMemberPw() + " ] 입니다.");
		} else {
			model.addAttribute("msg", "정보를 조회할 수 없습니다.");
		}
		model.addAttribute("loc", "/");
		return "common/msg";
	}

	@RequestMapping(value = "/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/"; // ViewResolver에게 앞 뒤 경로 달지 말라고 전달 // redirect:
	}

	@RequestMapping(value = "/deleteMember.do")
	public String deleteMember(String memberId, HttpSession session, Model model) {
		int result = service.deleteMember(memberId);

		if (result > 0) {
			session.invalidate();
			model.addAttribute("msg", "bye bye bye");
		} else {
			model.addAttribute("msg", "error 발생");
		}
		model.addAttribute("loc", "/");
		return "common/msg";
	}

	@RequestMapping(value = "/mypage.do")
	public String mypage(String memberId, Model model) {
		Member member = service.selectOneMemberId(memberId);

		model.addAttribute("member", member);
		return "member/mypage";
	}

	@RequestMapping(value = "/updateMemberInfo.do")
	public String updateMemberInfo(Member m) {
		int result = service.updateMemberInfo(m);

		return "redirect:/mypage.do?memberId=" + m.getMemberId(); // mypage 호출 서블릿
	}

	@RequestMapping(value = "/allMember.do")
	public String allMember(Model model) {
		List list = service.selectAllMember();
		model.addAttribute("list", list);

		return "member/allMember";
	}

	@RequestMapping(value = "/allMemberCount.do")
	public String allMemberCount(Model model) {
		int result = service.selectAllMemberCount();

		model.addAttribute("msg", "총 회원수는 " + result + " 명 입니다.");
		model.addAttribute("loc", "/");

		return "common/msg";
	}

	// 비밀번호 확인 창 이동
	@RequestMapping(value = "/checkPwFrm.do")
	public String checkPwFrm() {
		return "member/checkPwFrm";
	}

	// 비밀번호 확인
	@ResponseBody // ajax용 어노테이션 return 값을 그대로 주고 싶을 때
	@RequestMapping(value = "/checkPw.do")
	public String checkPw(Member m) {
		// 해당하는 아이디의 비밀번호가 일치하는지 확인
		Member member = service.selectOneMember(m);

		if (member != null) {
			// 입력한 비밀번호가 일치하는 경우
			return "1";
		} else {
			// 비밀번호 틀린 경우
			return "0";
		}
	}

	// 비밀번호 변경
	@RequestMapping(value = "/changePw.do")
	public String changePw(Member m, Model model) {
		int result = service.changePwMember(m);

		if (result > 0) {
			model.addAttribute("msg", "비밀번호 변경 성공");
		} else {
			model.addAttribute("msg", "비밀번호 변경 실패");
		}
		model.addAttribute("loc", "/mypage.do?memberId=" + m.getMemberId());

		return "common/msg";
	}

	// ID 중복 체크
	@ResponseBody // ajax용 어노테이션 return 값을 그대로 주고 싶을 때
	@RequestMapping(value = "/checkId.do")
	public String checkId(String memberId) {
		Member member = service.selectOneMemberId(memberId);

		if (member == null) {
			// id 사용 가능
			return "1";
		} else {
			// id 중복
			return "0";
		}
	}

	@RequestMapping(value = "/allMemberAjax.do")
	public String allMemberFrm() {
		return "member/allMemberAjax";
	}

	@ResponseBody
	@RequestMapping(value = "/allMemAjax.do", produces = "application/json;charset=utf-8")
	public String allMemAjax() {
		List list = service.selectAllMember();

		return new Gson().toJson(list);
	}

}