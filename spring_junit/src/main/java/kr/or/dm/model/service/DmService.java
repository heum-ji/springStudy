package kr.or.dm.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.dm.model.dao.DmDao;
import kr.or.dm.model.vo.Dm;
import kr.or.member.model.vo.Member;

@Service
public class DmService {
	@Autowired
	private DmDao dao;

	// 쪽지 조회
	public List selectAllDm(Member m) {
		return dao.selectAllDm(m);
	}

	public int insertDm(Dm d) {
		return dao.insertDm(d);
	}

}
