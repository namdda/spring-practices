package com.bitacademy.mysite.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.bitacademy.mysite.repository.GuestbookRepository;
import com.bitacademy.mysite.vo.GuestbookVo;
import com.bitacademy.mysite.service.GuestbookService;


@Controller
@RequestMapping("/guestbook")
public class GuestbookController {
	
	@Autowired
	private GuestbookService GuestbookService;
	
	@RequestMapping("")
	public String index(Model model) {
		
		List<GuestbookVo> list = GuestbookService.findAll();
		model.addAttribute("list", list);
		return "guestbook/index";	
	}
	
	
	@RequestMapping("/add")
	public String form(GuestbookVo vo) {
		GuestbookService.insert(vo);
		return "redirect:/";
	}
	
	
	@RequestMapping(value="/delete/{no}", method = RequestMethod.GET)
	public String delete(@PathVariable("no") Long no,Model model) {
			
		model.addAttribute("no", no);
		return "guestbook/delete";
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public String delete(GuestbookVo vo) {
			
		GuestbookService.delete(vo);
		return "redirect:/";
	}
}