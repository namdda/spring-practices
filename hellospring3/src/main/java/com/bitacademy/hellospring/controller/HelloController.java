package com.bitacademy.hellospring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/hello") // 요청과 핸들러 매핑에 대한 설정 정보  : 이 메서드가 핸들러 역할
	// dispatcher 서블릿에서 스프링 컨테이너에서 받은 핸들러 매핑 정보(컨테이너가 어노테이션을 스캐닝해서 정보를 가지고 있음)
	// 를 바탕으로 요청(url)과 맞는 것을 호출 
	// 현재의 servletContextPath를 알고 있으므로 예전처럼 /hellospring03/ 표시  x
	// ==> 서블릿컨테이너의 기술(톰캣)의 servletContextPath 투입 방지
	public String hello() { // 추후에 설명. 바로 body로 응답 보냄
		return "/WEB-INF/views/hello.jsp";
	}
	// hello2?n=안대혁 받아야 하면 
	/*
	 * public String hello2(@RequestParam("n" String name) {
		return "/WEB-INF/views/hello.jsp";
	}
	 * */
	@RequestMapping("/hello2")
	public String hello2(String name) {
		System.out.println(name);
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/hello3")
	public ModelAndView hello3(String name) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/views/hello.jsp");
		mav.addObject("name",name);
		
		return mav;
		
	}
	
	@RequestMapping("/hello4")
	public String hello4(String name, Model model) {
		model.addAttribute("name", name);
		return "/WEB-INF/views/hello.jsp";
		
	}
	
	@RequestMapping(value= "/hello5", produces ="text/html;charset=utf-8")
	@ResponseBody
	public String hello5(String name) {

		return "Hello "+name;
		
	}
	
	

}
