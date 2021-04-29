package com.bitacademy.semiproject.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.semiproject.exception.UserRepositoryException;
import com.bitacademy.semiproject.vo.UserVo;

@Repository
public class UserRepository {
	@Autowired
	private SqlSession sqlSession;
	
	public UserVo findByNo(Long no) {
		return sqlSession.selectOne("user.find", no);
	}

	public UserVo findByEmailAndPassword(UserVo vo) throws UserRepositoryException {
		return sqlSession.selectOne("user.findByEmailAndPassword", vo);
	}
	
	public UserVo find(UserVo vo) throws UserRepositoryException {
		return sqlSession.selectOne("user.find", vo);
	}
	
	public boolean insert(UserVo vo) {
		System.out.println(vo.getNo());
		int count = sqlSession.insert("user.insert", vo);
		System.out.println(vo.getNo());
		return count == 1;
	}

	public boolean update(UserVo vo) {
		int count = sqlSession.insert("user.update", vo);
		return count == 1;
	}

	public UserVo findByEmail(String email) {
		return sqlSession.selectOne("user.findByEmail", email);
	}
}