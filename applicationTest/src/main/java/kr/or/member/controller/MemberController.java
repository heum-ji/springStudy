package kr.or.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/member")
public class MemberController {

	@RequestMapping(value = "/selectOne.do")
	public String selectOne() {
		System.out.println("MemberController : selectOne");
		return "redirect:/";
	}

	@RequestMapping(value = "/insert.do")
	public String insert() {
		System.out.println("MemberController : insert");
		return "redirect:/";
	}
}
