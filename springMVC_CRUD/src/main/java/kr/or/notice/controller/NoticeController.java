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

	// 전체 공지사항 조회
	@RequestMapping(value = "/allNotice.do")
	public String allNotice(Model model) {
		List list = service.selectAllNotice();
		model.addAttribute("list", list);

		return "notice/allNotice";
	}

	// 공지사항 상세보기
	@RequestMapping(value = "/noticeView.do")
	public String noticeView(int noticeNo, Model model) {
		Notice notice = service.selectOneNotice(noticeNo);

		model.addAttribute("notice", notice);

		return "notice/noticeView";
	}

	// 공지사항 작성 화면
	@RequestMapping(value = "/noticeWriteFrm.do")
	public String noticeWriteFrm() {
		return "notice/noticeWriteFrm";
	}

	// 공지사항 작성
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

	// 공지사항 수정 화면
	@RequestMapping(value = "/noticeUpdateFrm.do")
	public String noticeUpdateFrm(int noticeNo, Model model) {
		Notice notice = service.selectOneNotice(noticeNo);

		model.addAttribute("notice", notice);

		return "notice/noticeUpdateFrm";
	}

	// 공지사항 수정
	@RequestMapping(value = "/updateNotice.do")
	public String updateNotice(Notice n, Model model) {
		int result = service.updateNotice(n);

		if (result > 0) {
			model.addAttribute("msg", "공지사항 수정 성공");
		} else {
			model.addAttribute("msg", "공지사항 수정 실패");
		}
		model.addAttribute("loc", "/noticeView.do?noticeNo=" + n.getNoticeNo());
		return "common/msg";
	}

	// 공지사항 삭제
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