package kr.or.user.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.user.model.vo.User;

@Repository
public class UserDao {
	@Autowired
	private SqlSessionTemplate sqlSession;

	// 회원 조회
	public User selectOneUser(User u) {
		return sqlSession.selectOne("user.selectOneUser", u);
	}

	// 회원 탈퇴
	public int deleteUser(String email) {
		return sqlSession.delete("user.deleteUser", email);
	}

	// 회원 가입
	public int insertUser(User u) {
		return sqlSession.insert("user.insertUser", u);
	}

	// 회원 정보 수정
	public int updateUser(User u) {
		return sqlSession.update("user.updateUser", u);
	}
}
