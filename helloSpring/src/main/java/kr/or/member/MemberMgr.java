package kr.or.member;

public class MemberMgr {
	private Member m;

	public MemberMgr() {
		super();
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