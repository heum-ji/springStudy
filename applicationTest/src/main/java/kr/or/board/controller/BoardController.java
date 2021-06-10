package kr.or.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

	@RequestMapping(value = "/selectOne.do")
	public String selectOne() {
		System.out.println("BoardController : selectOne");
		return "redirect:/";
	}

	@RequestMapping(value = "/insert.do")
	public String insert() {
		System.out.println("BoardController : insert");
		return "redirect:/";
	}

}
