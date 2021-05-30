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

	@RequestMapping(value = "/noticeWrite.do")
	public String noticeWrite(Notice n, Model model) {
		int result = service.insertNotice(n);

		if (result > 0) {
			model.addAttribute("msg", "공지사항 작성 성공");
		} else {
			model.addAttribute("msg", "공지사항 작성 실패");
		}
		model.addAttribute("loc", "/allNotice.do");
		return "common/msg";
	}
	
	@RequestMapping(value = "/noticeUpdateFrm.do")
	public String noticeUpdateFrm(int noticeNo, Model model) {
		Notice notice = service.selectOneNotice(noticeNo);
		
		model.addAttribute("notice", notice);
		
		return "notice/noticeUpdateFrm";
	}
	
	@RequestMapping(value = "/deleteNotice.do")
	public String deleteNotice(int noticeNo, Model model) {
		int result = service.deleteNotice(noticeNo);
		
		if (result > 0) {
			model.addAttribute("msg", "공지사항 삭제 성공");
		} else {
			model.addAttribute("msg", "공지사항 삭제 실패");
		}
		model.addAttribute("loc", "/allNotice.do");
		return "common/msg";
	}
}
