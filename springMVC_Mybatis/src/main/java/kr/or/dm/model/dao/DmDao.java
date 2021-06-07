package kr.or.dm.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.dm.model.vo.Dm;
import kr.or.member.model.vo.Member;

@Repository
public class DmDao {
	@Autowired
	private SqlSessionTemplate sqlSession;

	public List selectAllDm(Member m) {
		return sqlSession.selectList("dm.selectAllDm", m);
	}

	public int insertDm(Dm d) {
		return sqlSession.insert("dm.insertDm", d);
	}

}
