package com.poly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.dao.AccountDao;
import com.poly.entity.Account;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	@Autowired
	AccountDao accDao;
	@Autowired
	HttpSession ses;
	
	
	@RequestMapping(value = "/index/login")
	public String login(Model model) {
		
		
		return "/views/login";
	}

	@RequestMapping(value = "/index/login", method = RequestMethod.POST)
	public String loginP(@RequestParam("username") String ur, @RequestParam("password") String pw, Model model) {
		if (ur.isBlank() || pw.isBlank()) {
			model.addAttribute("mes", "Enter complete information");
			return "/views/login";
		} else {
			try {
				Account acc = accDao.findByUserName(ur).get(0);
				if(acc.getPassWord().equals(pw)) {
					ses.setAttribute("userSes",acc);
					model.addAttribute("mes", "Login Success!");
					return "redirect:/index";
				} else {
					model.addAttribute("mes", "Invalid Username or Password");
					return "/views/login";
				}
			} catch (Exception e) {
				model.addAttribute("mes", "Invalid Username or Password");
				return "/views/login";
			}

		}
	}

}
