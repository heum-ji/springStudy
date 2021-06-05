package kr.or.coupon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import kr.or.coupon.model.service.CouponService;
import kr.or.coupon.model.vo.Coupon;
import kr.or.member.model.vo.Member;

@Controller
public class CouponController {
	@Autowired
	CouponService service;

	// 내 쿠폰 확인
	@RequestMapping(value = "/couponList.do")
	public String couponList(@SessionAttribute(required = false) Member m, Model model) {
		List<Coupon> list = service.selectAllCoupon(m);

		model.addAttribute("list", list);

		return "coupon/couponList";
	}

	// 쿠폰 만료 처리
	@Transactional
	@RequestMapping(value = "/couponExpired.do")
	public String expireCoupon(Model model) {
		int result = service.expireCoupon();

		if (result > 0) {
			model.addAttribute("msg", "총 " + result + "개 쿠폰이 만료되었습니다.");
		} else {
			model.addAttribute("msg", "만료된 쿠폰이 없습니다!");
		}
		model.addAttribute("loc", "/");

		return "common/msg";
	}
}