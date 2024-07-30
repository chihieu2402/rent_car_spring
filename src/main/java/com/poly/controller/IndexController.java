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
//		Account acc = (Account) ses.getAttribute("userSes");
//		System.out.println("User: "+acc);
//		if(acc!=null) {
//			model.addAttribute("log", "Welcome! "+acc.getUserName());
//		} else {
//			model.addAttribute("log", "Login");
//		}
		return "/views/index";
	}

	@RequestMapping(value="/index/signup", method=RequestMethod.GET)
	public String signup() {
		return "/views/signup";
	}
}
