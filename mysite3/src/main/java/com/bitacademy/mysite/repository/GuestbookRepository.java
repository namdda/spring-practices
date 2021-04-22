package com.bitacademy.mysite.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.mysite.vo.GuestbookVo;

@Repository
public class GuestbookRepository {

	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private DataSource dataSource;
	
	public boolean delete(GuestbookVo vo) {
		boolean result = false;

		int count = sqlSession.delete("guestbook.delete", vo);
		result = count == 1;
	
		return result;
	}

	public boolean insert(GuestbookVo vo) {
		boolean result = false; 
		int count = sqlSession.insert("guestbook.insert", vo);
		
		result = count == 1;		
		
	
		return result;
	}

	public List<GuestbookVo> findAll() {
		List<GuestbookVo> list = sqlSession.selectList("guestbook.findAll");
		
		
		return list;
	}
}