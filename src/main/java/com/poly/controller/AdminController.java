package com.poly.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.poly.dao.CarDao;
import com.poly.entity.Car;
import com.poly.entity.Review;

@Controller
public class AdminController {
	@Autowired
	CarDao car;
    
    @GetMapping("/thongke")
    public String Thongke(Model model) {
       
        return "views/admin/Thongke"; // Main template with dynamic content
    }
    @RequestMapping("/car")
    public String car(Model model) {
    	List<Car> lcar = car.findAll();
        return "views/admin/Car"; // Main template with dynamic content
    }
	

    
}
