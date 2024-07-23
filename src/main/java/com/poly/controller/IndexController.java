package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class IndexController {
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index() {
		return "/views/index";
	}
	@RequestMapping(value="/index/login", method=RequestMethod.GET)
	public String login() {
		return "/views/login";
	}
	@RequestMapping(value="/index/signup", method=RequestMethod.GET)
	public String signup() {
		return "/views/signup";
	}
}
