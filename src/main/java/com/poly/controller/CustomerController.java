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

import com.poly.dao.CustomerDao;
import com.poly.entity.Account;
import com.poly.entity.Customer;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class CustomerController {
    
    @Autowired
    private CustomerDao customerDao;

    @GetMapping("/Customer")
    public String customers(Model model) {
        List<Customer> customers = customerDao.findAll();
        model.addAttribute("customers", customers);
        model.addAttribute("customer", new Customer());
        return "views/admin/Customer";
    }

    @PostMapping("/customer/create")
    public String createCustomer(@ModelAttribute("customer") Customer customer) {
        customerDao.save(customer);
        return "redirect:/admin/Customer";
    }

    @PostMapping("/customer/update")
    public String updateCustomer(@ModelAttribute("customer") Customer customer) {
    	try {
   		 Customer u = customerDao.findByCustomerID(customer.getCustomerID());
      		  customerDao.save(customer);
		} catch (Exception e) {
			System.out.println("Đ có làm sao m update");
		}

       return "redirect:/admin/Customer";
    }
    
    @GetMapping("/customer/edit/{id}")
    public String editCustomer(@PathVariable("id") Integer customerID, Model model) {
    	model.addAttribute("able", true);
        Customer customer = customerDao.findById(customerID).orElse(null);
        model.addAttribute("customer", customer);
        List<Customer> customers = customerDao.findAll();
        model.addAttribute("customers", customers);
        return "views/admin/Customer";
    }

    @PostMapping("/customer/delete/{id}")
    public String deleteCustomer(@PathVariable("id") Integer customerID) {
        customerDao.deleteById(customerID);
        return "redirect:/admin/Customer";
    }
    @PostMapping("/customer/reset")
    public String reset(Model model) {
      
        return "redirect:/admin/Customer";
    }
}
