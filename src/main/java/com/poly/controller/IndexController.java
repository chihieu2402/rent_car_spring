package com.poly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.poly.entity.Account;

import jakarta.servlet.http.HttpSession;


@Controller
public class IndexController {
	@Autowired
	HttpSession ses;
	@RequestMapping(value="/index")
	public String index(Model model) {
		Account acc = (Account) ses.getAttribute("userSes");
		if(acc!=null) {
			model.addAttribute("log",0);
		} else {
			model.addAttribute("log",1);
		}
		return "/views/index";
	}

	@RequestMapping(value="/index/signup", method=RequestMethod.GET)
	public String signup() {
		return "/views/signup";
	}
	@RequestMapping(value="/index/about", method=RequestMethod.GET)
	public String about() {
		return "/views/about";
	}
}
