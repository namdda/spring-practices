package com.bitacademy.semiproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.semiproject.vo.UserVo;
import com.bitacademy.semiproject.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public void join(UserVo vo) {
		userRepository.insert(vo);
		// 메일 보내기
	}

	public UserVo getUser(UserVo vo) {
		return userRepository.findByEmailAndPassword(vo);
	}
	
	public UserVo getUser2(UserVo vo) {
		return userRepository.find(vo);
	}

	public UserVo getUser(Long no) {
		return userRepository.findByNo(no);
	}

	public void updateUser(UserVo vo) {
		userRepository.update(vo);
	}

	public Boolean existUser(String email) {
		UserVo userVo = userRepository.findByEmail(email);
		return userVo != null;
	}	
}