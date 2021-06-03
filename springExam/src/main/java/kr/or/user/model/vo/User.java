package kr.or.user.model.vo;

import lombok.Data;

@Data
public class User {
	private int userNo;
	private String email;
	private String userPw;
	private String userName;
	private int age;
}
