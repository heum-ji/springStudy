package kr.or.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.user.model.service.UserService;
import kr.or.user.model.vo.User;

@Controller
public class UserController {
	@Autowired
	private UserService service;

	// 로그인
	@RequestMapping(value = "/login.do")
	public String login(User u, Model model, HttpSession session) {
		User user = service.selectOneUser(u);

		// 로그인 성공한 경우
		if (user != null) {
			session.setAttribute("u", user);
			model.addAttribute("msg", "로그인 성공~!!");
		} else {
			model.addAttribute("msg", "이메일 또는 비밀번호를 확인해주세요.");

		}
		model.addAttribute("loc", "/");

		return "common/msg";
	}

	// 회원가입 창 이동
	@RequestMapping(value = "/joinFrm.do")
	public String joinFrm() {
		return "user/joinFrm";
	}

	// 이메일 중복체크 - ajax
	@ResponseBody
	@RequestMapping(value = "checkEmail.do")
	public String checkEmail(User u) {
		User user = service.selectOneUser(u);
		// 사용 가능
		if (user == null) {
			return "1";
		} else { // 중복
			return "0";
		}
	}

	// 회원 가입
	@Transactional
	@RequestMapping(value = "/join.do")
	public String join(User u, Model model) {
		int result = service.insertUser(u);

		// 회원가입 성공
		if (result > 0) {
			model.addAttribute("msg", "회원가입 성공!!!");
		} else {
			model.addAttribute("msg", "회원가입 실패 ㅠㅠ");
		}
		model.addAttribute("loc", "/");

		return "common/msg";
	}

	// 로그아웃
	@RequestMapping(value = "/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();

		return "redirect:/";
	}

	// 회원 정보 창 이동
	@RequestMapping(value = "/myinfo.do")
	public String myinfo() {
		return "user/myinfo";
	}

	// 회원 정보 수정
	@Transactional
	@RequestMapping(value = "/updateUser.do")
	public String updateUser(User u, Model model) {
		int result = service.updateUser(u);

		if (result > 0) {
			model.addAttribute("msg", "회원 정보 수정 성공!!");
		} else {
			model.addAttribute("msg", "회원 정보 수정 실패!!");
		}
		model.addAttribute("loc", "/");

		return "common/msg";
	}

	// 회원 탈퇴
	@Transactional
	@RequestMapping(value = "/deleteUser.do")
	public String deleteUser(String email, HttpSession session, Model model) {
		int result = service.deleteUser(email);

		if (result > 0) {
			session.invalidate();
			model.addAttribute("msg", "잘가~~");
		} else {
			model.addAttribute("msg", "[회원 탈퇴 실패!!] 서버 담당자에게 문의 바랍니다.");
		}
		model.addAttribute("loc", "/");

		return "common/msg";
	}

	// 비밀번호 찾기 창 - email / userName
	@RequestMapping(value = "/searchFrm.do")
	public String searchFrm() {
		return "user/searchFrm";
	}

	// 비밀번호 찾기
	@RequestMapping(value = "/searchPw.do")
	public String searchPw(User u, Model model) {
		User user = service.selectOneUser(u);

		// 비밀번호 찾은 경우
		if (user != null) {
			model.addAttribute("msg", "당신의 비밀번호는 [ " + user.getUserPw() + " ] 입니다.");
		} else {
			model.addAttribute("msg", "이메일 또는 이름을 확인해주세요.");
		}
		model.addAttribute("loc", "/");

		return "common/msg";
	}
}
