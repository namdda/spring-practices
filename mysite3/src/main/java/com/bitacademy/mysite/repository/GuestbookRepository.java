package com.bitacademy.mysite.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bitacademy.mysite.vo.GuestbookVo;


@Repository
public class GuestbookRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
	 //1. 방명록 전체 list찾기
	 public List<GuestbookVo> findAll() {
		 
		  return sqlSession.selectList("guestbook.findAll");
		
	}
	
	//2. 방명록작성
	public boolean insert(GuestbookVo vo) {

		int count = sqlSession.insert("guestbook.insert",vo);
		return count ==1;	

	}
	
	//3. 방명록삭제
	public boolean delete(GuestbookVo vo) {
		
		int count = sqlSession.delete("guestbook.delete", vo);
		return count ==1;	
	}
}