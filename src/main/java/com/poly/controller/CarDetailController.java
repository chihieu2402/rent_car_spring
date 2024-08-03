package com.poly.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poly.dao.AccountDao;
import com.poly.dao.CarDao;
import com.poly.dao.CustomerDao;
import com.poly.dao.ReviewDao;
import com.poly.entity.Account;
import com.poly.entity.Car;
import com.poly.entity.Review;


@Controller
public class CarDetailController {

	@Autowired
	CarDao carDao;
	
	@Autowired
	ReviewDao reviewDao;
	
	@Autowired 
	AccountDao accountDao;
	
	@RequestMapping( value = "/index/cars/{id}", method = RequestMethod.GET)
	public String getCarDetail(@PathVariable("id") int idcar, Model model) {

		
		
//		tìm cardetail theo carid
		Car carDetail = carDao.findByCarID(idcar).get(0); 
		model.addAttribute("carDetail",carDetail);
		
//		tìm review theo carID
		List<Review> reviewByCarID = reviewDao.findByCarID(idcar);
		model.addAttribute("reviewByCarID",reviewByCarID);
		
//		tim sao trung bình theo carID
		double ratingTB = reviewDao.findAverageRatingByCarId(idcar);
		model.addAttribute("ratingTB",ratingTB);
		 return "/views/carDetail";
		
	}
	
	
	@RequestMapping( value = "/index/cars/{id}", method = RequestMethod.POST)
	public String postCarDetail(Review review, @RequestParam("rateCarDetail") int rating, Model model,@PathVariable("id") int idcar) {
		// lấy thông tin của người dùng đã đăng nhập
				 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//					kiểm tra người dùng có tồn tại, đã đăng nhập chưa
//				 if (authentication != null && authentication.isAuthenticated()) {
//			            // Lấy tên người dùng
//			            String username = authentication.getName();
//			            model.addAttribute("username", username);
//			            
//			            // tim account đã đăng nhập, lấy id
//			           Account accountLogin = accountDao.findByUserName(username).get(0);
//			           int accountID =  accountLogin.getAccountID();
//			           
//			           review.setRating(rating);
//			           review.setCustomer(accountLogin.getCustomer());
//			           review.setCarID(idcar);
//			           review.setReviewDate(new Date());
//			           
//			           reviewDao.save(review);
//			        }
			       Account accountLogin = accountDao.findByUserName("minhben12").get();
			     review.setRating(rating);
		           review.setCustomerID(accountLogin.getAccountID());
		           review.setCarID(idcar);
		           review.setReviewDate(new Date());
		           
		           reviewDao.save(review);
		
		return "redirect:/index/cars/{id}";
		
	}
}
