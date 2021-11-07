package com.uhs.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uhs.dto.Product;

@RestController
@RequestMapping(path="/api/cart")
public class cartController {

	@SuppressWarnings("unchecked")
	@PostMapping
	public String writeCart(HttpServletRequest request, HttpSession session) {
		long id = Long.parseLong(request.getParameter("id"));
		int price = Integer.parseInt(request.getParameter("price"));
		String name = request.getParameter("name");
				
		ArrayList<Product> al = (ArrayList<Product>) session.getAttribute("cartlist");
		
		if(al == null) al = new ArrayList<Product>();
		
		Product product = new Product();	
		boolean exist = false;
		
		for(int i = 0; i < al.size(); i++) {
			product = al.get(i);
			if(product.getId() == id) {
				product.setId(id);
				product.setPname(name);
				product.setUnitPrice(price);
				if(product.getUnitsInstock() == null) product.setUnitsInstock((long) 1);
				else product.setUnitsInstock(product.getUnitsInstock() + 1);
				al.set(i, product);
				
				exist = true;
				break;
			}
		}
		
		if(!exist) {
			product = new Product();
			product.setId(id);
			product.setPname(name);
			product.setUnitPrice(price);
			product.setUnitsInstock((long) 1);
			al.add(product);
		}
		
		session.setAttribute("cartlist", al);
		
		return "redirect:../cart";
	}
	
	@SuppressWarnings("unchecked")
	@DeleteMapping("/{id}")
	public String deleteCart(@PathVariable(name = "id") long id, HttpSession session) {				
		ArrayList<Product> al = (ArrayList<Product>) session.getAttribute("cartlist");
		
		if(al == null) al = new ArrayList<Product>();
		
		Product product = new Product();	
		
		for(int i = 0; i < al.size(); i++) {
			product = al.get(i);
			if(product.getId() == id) {
				al.remove(i);
				break;
			}
		}
			
		session.setAttribute("cartlist", al);
		
		return "redirect:../cart";
	}
}
