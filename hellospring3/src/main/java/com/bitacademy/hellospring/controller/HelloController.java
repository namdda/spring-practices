package com.bitacademy.hellospring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello() {
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
		System.out.println("name");
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
	
	@ResponseBody
	@RequestMapping("/hello5")
	public String hello5(String name) {
		return "Hello"+name;
		
	}
}
