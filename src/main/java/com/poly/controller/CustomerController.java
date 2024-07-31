package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.dao.CustomerDao;
import com.poly.entity.Customer;

@RequestMapping(value ="/admin")
@Controller
public class CustomerController {
	 
	  @Autowired
	  private CustomerDao customerDao; // Assuming you have a DAO for Customer
	   @GetMapping("/Customer")
	    public String listCustomers(Model model) {
	        List<Customer> customers = customerDao.findAll(); // Fetch all customers
	        model.addAttribute("customers", customers); // Add customers to the model
	        model.addAttribute("customer", new Customer()); // Initialize a new Customer object for the form
	        return "views/admin/Customer"; // Return the correct view for customer management
	    }

}
