package kr.or.coupon.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.coupon.model.vo.Coupon;
import kr.or.member.model.vo.Member;

@Repository
public class CouponDao {
	@Autowired
	private SqlSessionTemplate sqlSession;

	// 내 쿠폰 확인
	public List<Coupon> selectAllCoupon(Member m) {
		return sqlSession.selectList("coupon.selectAllCoupon", m);
	}

	// 쿠폰 만료 처리
	public int expireCoupon() {
		return sqlSession.update("coupon.expireCoupon");
	}
}
