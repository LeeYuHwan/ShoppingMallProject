package com.uhs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uhs.dto.Shipping;
import com.uhs.factory.ordererFactory;
import com.uhs.service.productService;

@RestController
@RequestMapping(path="/api/orderer")
public class orderController {
	@Autowired
	productService productService;
	
	@PostMapping
	public String orderProduct(HttpServletRequest request) {
		String returnUrl = "";
		
		try {
			long productId = Long.parseLong(request.getParameter("productId"));
			String name = request.getParameter("name");
			String shippingDay = request.getParameter("shippingDay");
			String country = request.getParameter("country");
			String zipCode = request.getParameter("zipCode");
			String address = request.getParameter("address");
			
			Shipping shipping = new ordererFactory().makeorderer(new Shipping(), productId, name, shippingDay, country, zipCode, address);
			productService.addShippingInfo(shipping);
			
			returnUrl = "redirect:./orderComplete";
		}
		catch (Exception e) {
			returnUrl = "redirect:./error";
		}
			
		return returnUrl;
	}
}
