package com.uhs.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.uhs.dto.Product;
import com.uhs.service.productService;

@Controller
public class productController {
	@Autowired
	productService productService;
	
	@PostMapping(path = "/registration")
	public String registration(@RequestBody HashMap<String, Object> resMap) {	
		
		System.out.println("상품 insert 실행 : " + resMap);
		
		Product product = new Product();
		
		product.setProductId(resMap.get("productId").toString());
		product.setPname(resMap.get("pname").toString());
		product.setUnitPrice(Integer.parseInt(resMap.get("unitPrice").toString()));
		product.setDescription(resMap.get("description").toString());
		product.setManufacturer(resMap.get("manufacturer").toString());
		product.setCategory(resMap.get("category").toString());
		product.setUnitsInstock(Long.parseLong(resMap.get("unitsInstock").toString()));
		product.setPcondition(resMap.get("pcondition").toString());
		
		productService.addProductInfo(product);
						
		return "redirect:./product";
	}
}

