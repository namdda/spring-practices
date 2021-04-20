/*
package com.bitacademy.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author BIT_R39
 *
 * @RequestMapping
 * Type(Class) 단독 매핑
 * 
 */

/*
@Controller
@RequestMapping("/guestbook/*")
public class GuestbookController {
	
	@ResponseBody
	@RequestMapping()
	public String list() {
		return "GuestbookController:list()";
	}

	@ResponseBody
	@RequestMapping()
	public String delete() {
		return "GuestbookController:delete()";
	}
	
}
*/


package com.bitacademy.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/guestbook/*")
public class GuestbookController {
	
	@ResponseBody
	@RequestMapping()
	public String list() {
		return "GuestbookController:list()";
	}

	@ResponseBody
	@RequestMapping("delete")
	public String delete() {
		return "GuestbookController:delete()";
	}
	
}


 
 