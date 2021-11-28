package com.uhs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {	
	@GetMapping("/")
	public String Home(Model model) {		
		return "login.jsp";
	}
	@GetMapping("/home")
	public String game(Model model) {				
		return "home.jsp";
	}
	@GetMapping("/login")
	public String login(Model model, HttpSession session) {		
		if(session.getAttribute("id") == null) return "login.jsp";
		else return "home.jsp";	
	}
	@GetMapping("/logout")
	public String logout(Model model, HttpSession session) {			
		session.invalidate();
		
		return "login.jsp";
	}
	@GetMapping("/sign-up")
	public String SignUp(Model model) {		
		return "sign-up.jsp";
	}
	
	
	@GetMapping("/error")
	public String error(Model model) {		
		return "error.jsp";
	}
}
