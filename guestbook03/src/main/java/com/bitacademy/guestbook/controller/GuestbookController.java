package com.bitacademy.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitacademy.guestbook.repository.GuestbookRepository;
import com.bitacademy.guestbook.vo.GuestbookVo;

@Controller
public class GuestbookController {
	@Autowired
	GuestbookRepository guestbookRepository;
	
	@RequestMapping({"","/", "/list"})
	public String list(Model model) {
		List<GuestbookVo> list = guestbookRepository.selectAll();
		model.addAttribute("list", list);		
		return "/WEB-INF/views/index.jsp";
	}
	@RequestMapping("/add")
	public String insert(GuestbookVo vo) {
		guestbookRepository.insert(vo);
		return "redirect:/";
	}
	@RequestMapping("/deleteform")
	public String deleteform(Model model,int no) {
		model.addAttribute("no", no);		
		return "/WEB-INF/views/deleteform.jsp";
	}

	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String delete(GuestbookVo vo) {
		guestbookRepository.delete(vo);
		return "redirect:/";
	}	

}