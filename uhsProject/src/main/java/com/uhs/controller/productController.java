package com.uhs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.uhs.dto.Product;
import com.uhs.factory.productFactory;
import com.uhs.service.productService;

@Controller
public class productController {
	@Autowired
	productService productService;
	
	@PostMapping(path = "/registration")
	public String registration(MultipartHttpServletRequest request) {				
		String returnUrl = "";		
		try {					
			String productId = request.getParameter("productId");
			String pname = request.getParameter("pname");
			int unitPrice = Integer.parseInt(request.getParameter("unitPrice"));
			String description = request.getParameter("description");
			String manufacturer = request.getParameter("manufacturer");
			String category = request.getParameter("category");
			long unitsInstock = Long.parseLong(request.getParameter("unitsInstock")); 
			String pcondition = request.getParameter("pcondition");
			MultipartFile file = request.getFile("file");
			
			Product product = new productFactory().makeProduct(new Product(), productId, pname, unitPrice, description, manufacturer, category, unitsInstock, pcondition, file);
			productService.addProductInfo(product);
			
			returnUrl = "redirect:./product";
		}
		catch (Exception e){
			returnUrl = "redirect:./error";
		}
								
		return returnUrl;
	}
}

