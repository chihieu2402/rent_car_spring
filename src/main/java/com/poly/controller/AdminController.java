package com.poly.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.poly.entity.Car;
import com.poly.entity.Review;

@Controller
public class AdminController {
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String index() {
        return "views/Admin";  // No leading slash needed
    }
    
    @GetMapping("/thongke")
    public String Thongke(Model model) {
       
        return "views/admin/Thongke"; // Main template with dynamic content
    }
    @GetMapping("/Car")
    public String car(Model model) {
       
        return "views/admin/Car"; // Main template with dynamic content
    }
	

    
}
