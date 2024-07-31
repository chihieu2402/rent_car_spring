package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.dao.BillDao;
import com.poly.entity.Bill;

@RequestMapping(value ="/admin")
@Controller
public class BillConttroller {
	 @Autowired
	 private BillDao billDao; // Assuming you have a DAO for Bill
	   @GetMapping("/Bill")
	    public String Bill(Model model) {
	        List<Bill> bills = billDao.findAll(); // Fetch all bills
	        model.addAttribute("bills", bills); // Add bills to the model
	        model.addAttribute("bill", new Bill()); // Initialize a new Bill object for the form
	        return "views/admin/Bill"; // Return the correct view for bill management
	    }
}
