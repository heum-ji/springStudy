package kr.or.tv.model.vo;

public class LgTV implements TV{
	public void powerOn() {
		System.out.println("LgTV --- 전원 ON");
	}

	public void powerOff() {
		System.out.println("LgTV --- 전원 OFF");
	}

	public void volumeUp() {
		System.out.println("LgTV --- 소리 UP");
	}

	public void volumeDown() {
		System.out.println("LgTV --- 소리 DOWN");
	}
}
