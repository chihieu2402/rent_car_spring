package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.dao.ReviewDao;
import com.poly.entity.Review;

@RequestMapping(value ="/admin")
@PreAuthorize("hasAuthority('ADMIN')")
@Controller
public class ReviewController {
	@Autowired
	 ReviewDao reviewDao;
	 
    @GetMapping("/Review")
    public String reviews(Model model) {
        List<Review> reviews = reviewDao.findAll(); // Fetch all reviews
        model.addAttribute("reviews", reviews); // Add reviews to the model
        model.addAttribute("review", new Review()); // Initialize a new Review object for the form
        return "views/admin/Review"; // Return the correct view for the review management page
    }
}
