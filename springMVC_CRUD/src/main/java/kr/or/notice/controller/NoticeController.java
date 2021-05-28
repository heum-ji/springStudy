package kr.or.notice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.notice.model.service.NoticeService;
import kr.or.notice.model.vo.Notice;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService service;

	@RequestMapping(value = "/allNotice.do")
	public String allNotice(Model model) {
		List list = service.selectAllNotice();
		model.addAttribute("list", list);

		return "notice/allNotice";
	}
	
	@RequestMapping(value = "/noticeView.do")
	public String noticeView(int noticeNo, Model model) {
		Notice notice = service.selectOneNotice(noticeNo);
		
		model.addAttribute("notice", notice);
		
		return "notice/noticeView";
	}
	
	@RequestMapping(value = "/noticeWriteFrm.do")
	public String noticeWriteFrm() {
		return"notice/noticeWriteFrm";
	}

	
}
