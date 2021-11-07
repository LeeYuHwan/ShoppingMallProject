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
	
	@GetMapping("/productInfo")
	public String productInfo(Model model, long id) {
				
		List<Product> listOfProducts = productService.getProductChoice(id);
		
		model.addAttribute("id", listOfProducts.get(0).getId());
		model.addAttribute("pname", listOfProducts.get(0).getPname());
		model.addAttribute("description", listOfProducts.get(0).getDescription());
		model.addAttribute("productId", listOfProducts.get(0).getProductId());
		model.addAttribute("manufacturer", listOfProducts.get(0).getManufacturer());
		model.addAttribute("category", listOfProducts.get(0).getCategory());
		model.addAttribute("unitsInstock", listOfProducts.get(0).getUnitsInstock());
		model.addAttribute("unitPrice", listOfProducts.get(0).getUnitPrice());
		model.addAttribute("imgName", listOfProducts.get(0).getImgName());
		
		return "productInfo.jsp";
	}
	
	@GetMapping("/cart")
	public String cart() {
				
		/*
		 * List<Product> listOfProducts = productService.getProductChoice(id);
		 * 
		 * model.addAttribute("pname", listOfProducts.get(0).getPname());
		 * model.addAttribute("description", listOfProducts.get(0).getDescription());
		 * model.addAttribute("productId", listOfProducts.get(0).getProductId());
		 * model.addAttribute("manufacturer", listOfProducts.get(0).getManufacturer());
		 * model.addAttribute("category", listOfProducts.get(0).getCategory());
		 * model.addAttribute("unitsInstock", listOfProducts.get(0).getUnitsInstock());
		 * model.addAttribute("unitPrice", listOfProducts.get(0).getUnitPrice());
		 * model.addAttribute("imgName", listOfProducts.get(0).getImgName());
		 */
		
		return "cart.jsp";
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
