package com.bitacademy.semiproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.semiproject.repository.GuestbookRepository;
import com.bitacademy.semiproject.vo.GuestbookVo;

@Service
public class GuestbookService {

	@Autowired
	private GuestbookRepository guestbookRepository;
	
	public List<GuestbookVo> getAllList() {
		
		List<GuestbookVo> list = guestbookRepository.findAll();
		
		return list;
	}

	public void insert(GuestbookVo vo) {
		
		guestbookRepository.insert(vo);
		
	}

	public void delete(GuestbookVo vo) {

		guestbookRepository.delete(vo);
	}

}