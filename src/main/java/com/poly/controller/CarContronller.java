package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.dao.CarDao;
import com.poly.entity.Car;

@RequestMapping(value ="/admin")
@Controller
public class CarContronller {
	
	  @Autowired
	  private CarDao carDao;
    
    @GetMapping("/car")
    public String car(Model model) {
        List<Car> cars = carDao.findAll();
        model.addAttribute("cars", cars);
        model.addAttribute("car", new Car()); // for the form
        return "views/admin/car"; // Main template with dynamic content
    }

}
