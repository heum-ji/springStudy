package kr.or.coupon.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.coupon.model.dao.CouponDao;
import kr.or.coupon.model.vo.Coupon;
import kr.or.member.model.vo.Member;

@Service
public class CouponService {
	@Autowired
	private CouponDao dao;

	// 내 쿠폰 확인
	public List<Coupon> selectAllCoupon(Member m) {
		return dao.selectAllCoupon(m);
	}

	// 쿠폰 만료 처리
	public int expireCoupon() {
		return dao.expireCoupon();
	}
}
