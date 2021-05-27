package kr.or.member;

public class MemberMgr {
	private Member m;

	public MemberMgr() {
		super();
		System.out.println("멤버매니저 객체 생성완료");
	}

	public MemberMgr(Member m) {
		super();
		this.m = m;
	}

	public Member getM() {
		return m;
	}

	public void setM(Member m) {
		this.m = m;
	}

}