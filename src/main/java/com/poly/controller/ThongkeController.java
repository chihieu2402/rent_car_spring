package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value ="/admin")
@Controller
public class ThongkeController {
	  @GetMapping("/thongke")
	    public String thongke(Model model) {
	        return "views/admin/Thongke"; // Main template with dynamic content
	  }

}
