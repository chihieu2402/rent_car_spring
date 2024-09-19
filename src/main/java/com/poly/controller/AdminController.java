package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.dao.AccountDao;
import com.poly.dao.BillDao;
import com.poly.dao.ReviewDao;
import com.poly.entity.Account;
import com.poly.entity.Bill;

@Controller
@RequestMapping(value ="/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {
    
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private ReviewDao reviewDao;


    
    @GetMapping("/account")
    public String users(Model model) {
        List<Account> accounts = accountDao.findAll();
        model.addAttribute("accounts", accounts);
        model.addAttribute("account", new Account());
        return "views/admin/User";
    }

    @PostMapping("/account/create")
    public String createAccount(@ModelAttribute("account") Account account) {
        accountDao.save(account);
        return "redirect:/admin/account";
    }

    @PostMapping("/account/update")
    public String updateAccount(@ModelAttribute("account") Account account) {
    	try {
    		 Account u = accountDao.findByAccountID(account.getAccountID());
       		  accountDao.save(account);
		} catch (Exception e) {
			System.out.println("Đ có làm sao m update");
		}
    	 
      
        return "redirect:/admin/account";
    }

    @GetMapping("/account/edit/{id}")
    public String editAccount(@PathVariable("id") int accountId, Model model) {
    	
        Account account = accountDao.findById(accountId).orElse(null);
        model.addAttribute("account", account);
        List<Account> accounts = accountDao.findAll();
        model.addAttribute("accounts", accounts);
        return "views/admin/user";
    }

    @PostMapping("/account/delete/{id}")
    public String deleteAccount(@PathVariable("id") int accountId) {
        accountDao.deleteById(accountId);
        return "redirect:/admin/account";
    }
    @PostMapping("/account/reset")
    public String reset(Model model) {
      
        return "redirect:/admin/account";
    }	
    
   
    
    @GetMapping("/Review")
    public String Review(Model model) {
        List<com.poly.entity.Review> reviews = reviewDao.findAll();
        model.addAttribute("reviews", reviews);
        model.addAttribute("review", new com.poly.entity.Review());
        return "views/admin/Review";
    }
}
