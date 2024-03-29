package com.bitacademy.mysite.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitacademy.mysite.security.Auth;
import com.bitacademy.mysite.security.AuthUser;
import com.bitacademy.mysite.security.Role;
import com.bitacademy.mysite.service.UserService;
import com.bitacademy.mysite.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		
		return "user/join";
	} 
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(UserVo vo) {
		userService.join(vo);
		
		return "redirect:/user/joinsuccess";
	}
	
	@RequestMapping("/joinsuccess")
	public String joinsuccess() {
		
		return "user/joinsuccess";
	} 

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		
		return "user/login";
	} 
/*
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(UserVo vo, HttpSession session) {
		
		// 접근제어
		UserVo authUser = userService.getUser(vo);
		if(authUser == null) {
			return "redirect:/user/login?result=fail";
		}
		
		
		// 세션에 로그인 한 user의 객체 정보를 set해준다. (로그인 처리)
		session.setAttribute("authUser", authUser);
		
		
		return "redirect:/";
	} 
*/

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		// 접근제어
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if(authUser == null) {
			return "redirect:/";
		}
		
		// 로그아웃 처리
		session.removeAttribute("authUser");
		session.invalidate();
		return "redirect:/";
	} 
	/*
	@Auth
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(@AuthUser UserVo authUser, Model model) {
		
		// 접근제어
		//UserVo authUser = (UserVo)session.getAttribute("authUser");
		/*
		if(authUser == null) {
			return "redirect:/";
		}
		
		
		Long no = authUser.getNo();
		UserVo userVo = userService.getUser(no);
		model.addAttribute("userVo", userVo);
		
		return "user/update";
	}
	*/
	
	@Auth
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(HttpSession session, Model model) {
		
		// 접근제어
		UserVo authUser = (UserVo)session.getAttribute("authUser");
				Long no = authUser.getNo();
		UserVo userVo = userService.getUser(no);
		model.addAttribute("userVo", userVo);
		
		return "user/update";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(HttpSession session, UserVo vo) {
		// 접근제어
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if(authUser == null) {
			return "redirect:/";
		}
		
		Long no = authUser.getNo();
		vo.setNo(no);
		
		userService.updateUser(vo);
		
		return "redirect:/user/update";
	}
	
	/*
	// 모든 예외가 모여서 처리하는 메서드
	@ExceptionHandler(Exception.class)
	public String handleException() {
		// 로그 작업
		
		// 사과문 페이지로 전달
		return "error/exception";
	}
	*/
}