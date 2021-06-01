package kr.or.common;

import java.security.MessageDigest;

import org.springframework.stereotype.Component;

@Component
public class SHA256Enc {

	public String encData(String data) throws Exception {
		// Spring Security의 MessageDigest객체를 이용한 암호화
		MessageDigest mDigest = MessageDigest.getInstance("SHA-256"); // SHA-256 알고리즘 사용

		// 매개변수로 받은 값을 byte 배열로 변환하여 mDigent에 저장
		mDigest.update(data.getBytes());

		// SHA256으로 변환 완료
		// 변환된 데이터를 byte배열로 꺼냄
		byte[] msgStr = mDigest.digest();

		// byte : -128 ~ 127 범위 -> 0 ~ 255로 변경
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < msgStr.length; i++) {
			byte tmp = msgStr[i];
			// byte -> HexString 
			// 0xff : 255 / 0x100 : 256
			// 0xff연산 : byte 원본 값 유지하기 위해서 / 맨 앞 bit가 1인 경우 보수처리 때문에 다른 값이 됨
			// 0x100 : 
			// sustring : 불필요한 제일 앞의 1을 제거하기 위해서
			String tmpText = Integer.toString((tmp & 0xff) + 0x100, 16).substring(1);
			sb.append(tmpText);
		}
		return sb.toString();
	}

}
