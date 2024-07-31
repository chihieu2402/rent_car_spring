package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
        return "views/admin/Car"; // Main template with dynamic content
    }

    @PostMapping("/car/create")	
    public String createCar(Car car) {
        carDao.save(car); // Save the new car to the database
        return "redirect:/Car"; // Redirect to the car management page
    }

    @PostMapping("/car/update")
    public String updateCar(Car car) {
        carDao.save(car); // Save the updated car to the database
        return "redirect:/Car"; // Redirect to the car management page
    }

    @PostMapping("/car/delete/{id}")
    public String deleteCar(@PathVariable int id) {
        carDao.deleteById(id); // Delete the car with the specified ID
        return "redirect:/Car"; // Redirect to the car management page
    }

}
