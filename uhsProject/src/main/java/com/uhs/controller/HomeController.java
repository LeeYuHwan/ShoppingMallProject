package com.uhs.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.uhs.dto.Product;
import com.uhs.service.productService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	productService productService;
	
	@GetMapping("/")
	public String Home(Model model) {		
		String greeting = "Welcome to Web Sopping Mall";
		String tagline = "Welcome to Web Market!";
		
		SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");			
		
		Date time = new Date();
		String currentTime = format.format(time);
		
		
		model.addAttribute("greeting", greeting);
		model.addAttribute("tagline", tagline);
		model.addAttribute("currentTime", currentTime);
		
		return "home.jsp";
	}	
	
	@GetMapping("/product")
	public String product(Model model) {
		
		List<Product> listOfProducts = productService.getProductAll();
		
		model.addAttribute("listOfProducts", listOfProducts);
		
		return "product.jsp";
	}
	
	@GetMapping("/registration")
	public String registration() {
		return "registPage.jsp";
	}
	
	@GetMapping("/index")
	public String index() {
		return "index.jsp";
	}
	@GetMapping("/20150819")
	public String week1() {
		return "20150819.html";
	}
	@GetMapping("/week2")
	public String week2() {
		return "week2.jsp";
	}
	@GetMapping("/week3")
	public String week3() {
		return "week3.html";
	}
}
