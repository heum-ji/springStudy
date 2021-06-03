package kr.or.user.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.user.model.dao.UserDao;
import kr.or.user.model.vo.User;

@Service
public class UserService {
	@Autowired
	private UserDao dao;

	// 회원 조회
	public User selectOneUser(User u) {
		return dao.selectOneUser(u);
	}

	// 회원 탈퇴
	public int deleteUser(String email) {
		return dao.deleteUser(email);
	}

	// 회원 가입
	public int insertUser(User u) {
		return dao.insertUser(u);
	}

	// 회원 정보 수정
	public int updateUser(User u) {
		return dao.updateUser(u);
	}

}
