package kr.or.dm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import kr.or.dm.model.service.DmService;
import kr.or.dm.model.vo.Dm;
import kr.or.member.model.vo.Member;

@Controller
public class DmController {
	@Autowired
	private DmService service;

	// 쪽지함 이동
	@RequestMapping(value = "/dmList.do")
	public String dmList(@SessionAttribute(required = false) Member m, Model model) {

		List list = service.selectAllDm(m);
		model.addAttribute("list", list);

		return "dm/dmList";
	}

	@ResponseBody
	@RequestMapping(value = "/sendDm.do")
	public int sendDm(Dm d) {
		int result = service.insertDm(d);

		return result;
	}
}
