package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.poly.dao.AccountDao;
import com.poly.dao.CarDao;
import com.poly.dao.ReviewDao;
import com.poly.entity.Account;
import com.poly.entity.Car;
import com.poly.entity.Review;
@Controller
public class AdminController {
	  @Autowired
	  private CarDao carDao;
	  @Autowired
	  ReviewDao reviewDao;
	  @Autowired
	  private AccountDao accountDao; // Assuming you have a DAO for Account
	  
	  
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String index() {
        return "views/Admin";  // No leading slash needed
    }
    
    @GetMapping("/thongke")
    public String thongke(Model model) {
        return "views/admin/Thongke"; // Main template with dynamic content
    }
    
    @GetMapping("/car")
    public String car(Model model) {
        List<Car> cars = carDao.findAll();
        model.addAttribute("cars", cars);
        model.addAttribute("car", new Car()); // for the form
        return "views/admin/car"; // Main template with dynamic content
    }
    
    @GetMapping("/Review")
    public String reviews(Model model) {
        List<Review> reviews = reviewDao.findAll(); // Fetch all reviews
        model.addAttribute("reviews", reviews); // Add reviews to the model
        model.addAttribute("review", new Review()); // Initialize a new Review object for the form
        return "views/admin/Review"; // Return the correct view for the review management page
    }
  

    @GetMapping("/users")
    public String users(Model model) {
        List<Account> accounts = accountDao.findAll(); // Fetch all accounts
        model.addAttribute("accounts", accounts); // Add accounts to the model
        model.addAttribute("account", new Account()); // Initialize a new Account object for the form
        return "views/admin/User"; // Return the correct view for user management
    }


}
