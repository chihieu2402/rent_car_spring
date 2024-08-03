package com.poly.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poly.dao.CarDao;
import com.poly.dao.ReviewDao;
import com.poly.entity.Car;
import com.poly.entity.Review;


@Controller
public class CarDetailController {

	@Autowired
	CarDao carDao;
	
	@Autowired
	ReviewDao reviewDao;
	
	@RequestMapping("/index/cars/{id}")
	public String getCarDetail(@PathVariable("id") int idcar, Model model) {
	
//		tìm cardetail theo carid
		Car carDetail = carDao.findById(idcar).get(); 
		model.addAttribute("carDetail",carDetail);
		
//		tìm Sao theo carID
		Review reviewByCarID = reviewDao.findByCarID(idcar);
		int rating = reviewByCarID.getRating();
		model.addAttribute("rating",rating);
		
		 return "/views/carDetail";
		
	}
	
}
