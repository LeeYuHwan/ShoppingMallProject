package com.uhs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uhs.dto.Shipping;
import com.uhs.service.productService;

@RestController
@RequestMapping(path="/api/orderer")
public class orderController {
	@Autowired
	productService productService;
	
	@PostMapping
	public String orderProduct(HttpServletRequest request) {
		Shipping shipping = new Shipping();
		String returnUrl = "";
		
		try {
			shipping.setProductId(Long.parseLong(request.getParameter("productId")));
			shipping.setName(request.getParameter("name"));
			shipping.setShippingDay(request.getParameter("shippingDay"));
			shipping.setCountry(request.getParameter("country"));
			shipping.setZipCode(request.getParameter("zipCode"));
			shipping.setAddress(request.getParameter("address"));
			
			productService.addShippingInfo(shipping);
			
			returnUrl = "redirect:./orderComplete";
		}
		catch (Exception e) {
			returnUrl = "redirect:./error";
		}
			
		return returnUrl;
	}
}
