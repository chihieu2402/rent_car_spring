package com.poly.controller;

import org.springframework.web.bind.annotation.RestController;

import com.poly.dao.AccountDao;
import com.poly.entity.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class AcountRestController {

	@Autowired
	AccountDao accountDao;
	
	@PostMapping("/rest/account")
	public Account post(@RequestBody Account account) {
		accountDao.save(account);
		
		return account;
	}
	
}
