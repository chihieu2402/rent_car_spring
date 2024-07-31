package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.dao.AccountDao;
import com.poly.entity.Account;


@RequestMapping(value ="/admin")
@Controller
public class AdminController {
	
	  @Autowired
	 
	  private AccountDao accountDao; // Assuming you have a DAO for Account

    @GetMapping("/users")
    public String users(Model model) {
        List<Account> accounts = accountDao.findAll(); // Fetch all accounts
        model.addAttribute("accounts", accounts); // Add accounts to the model
        model.addAttribute("account", new Account()); // Initialize a new Account object for the form
        return "views/admin/User"; // Return the correct view for user management
    }
    

}
