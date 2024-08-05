package com.poly.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.poly.Service.CarPostService;
import com.poly.Service.CarService;
import com.poly.Service.UpLoadSerVice;
import com.poly.auth.UserRoot;
import com.poly.dao.CarDao;
import com.poly.dao.PendingCarPostDao;
import com.poly.entity.Car;
import com.poly.entity.PendingCarPost;

import jakarta.servlet.http.HttpSession;

@Controller
public class IndexController {

    @Autowired
    private HttpSession session;
    
    @Autowired
    private CarDao carDao;
    
    @Autowired
    private CarService carService;
    
    @Autowired
    HttpSession ses; 
   
   

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model,Authentication auth) {
		ses.getAttribute("userSes");
        return "/views/index";
    }

    @RequestMapping(value = "/index/signup", method = RequestMethod.GET)
    public String signup() {
        return "/views/signup";
    }

    @RequestMapping(value = "/index/about", method = RequestMethod.GET)
    public String about(Model model) {
        return "/views/about";
    }

    @RequestMapping(value = "/index/pricing", method = RequestMethod.GET)
    public String pricing(Model model) {
        return "/views/pricing";
    }

    @RequestMapping(value = "/index/contact", method = RequestMethod.GET)
    public String contact(Model model) {
        return "/views/contact";
    }

    @RequestMapping(value = "/index/services", method = RequestMethod.GET)
    public String services(Model model) {
        return "/views/services";
    }

    @RequestMapping(value = "/index/blog", method = RequestMethod.GET)
    public String blog(Model model) {
        return "/views/blog";
    }

    @RequestMapping(value = "/index/cars", method = RequestMethod.GET)
    public String cars(Model model) {
        List<Car> list_car = carDao.findAll();
        model.addAttribute("cars", list_car);
        return "/views/car";
    }
	@PostMapping("/find-cars")
	public String getCarsByName(
	        @RequestParam String carName,
	        @RequestParam String address,
	        @RequestParam(required = false) String minPrice,
	        @RequestParam(required = false) String maxPrice,
	        Model model) {

	    Double minPriceDouble = (minPrice != null && !minPrice.isEmpty()) ? Double.valueOf(minPrice) : null;
	    Double maxPriceDouble = (maxPrice != null && !maxPrice.isEmpty()) ? Double.valueOf(maxPrice) : null;

	    List<Car> cars = carService.findCars(carName, address, minPriceDouble, maxPriceDouble);
	    model.addAttribute("cars", cars);
	    return "views/car";
    }

}
