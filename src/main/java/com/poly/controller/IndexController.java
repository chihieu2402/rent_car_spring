package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.poly.Service.CarPostService;
import com.poly.dao.CarDao;
import com.poly.dao.PendingCarPostDao;
import com.poly.entity.Car;
import com.poly.entity.PendingCarPost;

import jakarta.servlet.http.HttpSession;

@Controller
public class IndexController {
	@Autowired
	HttpSession ses;
	@Autowired
	CarDao carDao;
	@Autowired
	private PendingCarPostDao pendingCarPostDao;

	@Autowired
	private CarPostService carPostService;

	@RequestMapping(value = "/index")
	public String index(Model model) {
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
	// Hoài Hưng

	@RequestMapping(value = "/index/postcar", method = RequestMethod.GET)
	public String postcar() {
		return "views/postcar";
	}

	@PostMapping("/index/addPost")
	public String addPost(@ModelAttribute PendingCarPost pendingCarPost) {
		carPostService.addPost(pendingCarPost);
		return "redirect:/index/managePosts";
	}

	@RequestMapping(value = "/index/managePosts", method = RequestMethod.GET)
	public String managePosts(Model model) {
		model.addAttribute("posts", carPostService.getAllPendingPosts());
		return "views/managePosts";
	}

	@RequestMapping(value = "/index/approvePost", method = RequestMethod.POST)
	public String approvePost(int postID) {
		carPostService.approvePost(postID);
		return "redirect:/index/managePosts";
	}

	@RequestMapping(value = "/index/rejectPost", method = RequestMethod.POST)
	public String rejectPost(int postID) {
		carPostService.rejectPost(postID);
		return "redirect:/index/managePosts";
	}
}
