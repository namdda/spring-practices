package com.bitacademy.semiproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitacademy.semiproject.security.Auth;

@Controller
public class MainController {
	@RequestMapping("")
	public String index() {
		return "main/index";
	}
}