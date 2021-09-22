package com.uhs.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/home")
public class soppingMallHomeCon {
	
	@PostMapping(path="/init")
	public Map<String, Object> homeInit() {
		String greeting = "Welcome to Web Sopping Mall";
		String tagline = "Welcome to Web Market!";
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("greeting", greeting);	
		map.put("tagline", tagline);
		
		return map;
	}
}
