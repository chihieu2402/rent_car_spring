package com.poly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.dao.AccountDao;
import com.poly.entity.Account;

@Controller
public class LoginController {
	@Autowired
	AccountDao accDao;

	@RequestMapping(value = "/index/login")
	public String login() {
		return "/views/login";
	}

	@RequestMapping(value = "/index/login", method = RequestMethod.POST)
	public String loginP(@RequestParam("username") String ur, @RequestParam("password") String pw, Model model) {
		if (ur.isBlank() || pw.isBlank()) {
			model.addAttribute("mes", "Nhập đầy đủ thông tin");
			return "/views/login";
		} else {
			try {
				Account acc = accDao.findByUserName(ur).get(0);
				if(acc.getPassWord().equals(pw)) {
					model.addAttribute("mes", "Đăng nhập thành công!");
					return "redirect:/index";
				} else {
					model.addAttribute("mes", "Sai mật khẩu");
					return "/views/login";
				}
			} catch (Exception e) {
				model.addAttribute("mes", "Tài khoản không tồn tại");
				return "/views/login";
			}

		}
	}

}
