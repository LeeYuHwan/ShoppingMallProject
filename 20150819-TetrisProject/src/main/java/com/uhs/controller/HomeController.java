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
	@GetMapping("/title")
	public String title(Model model) {				
		return "titleMain.jsp";
	}
	@GetMapping("/rank")
	public String rank(Model model) {				
		return "rank.jsp";
	}
	@GetMapping("/login")
	public String login(Model model, HttpSession session) {		
		if(session.getAttribute("id") == null) return "login.jsp";
		else return "home.jsp";	
	}
	@GetMapping("/findpw")
	public String findPW(Model model) {				
		return "findPW.jsp";
	}
	@GetMapping("/changepw")
	public String changePW(Model model) {				
		return "changePW.jsp";
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
	@GetMapping("/delete-member")
	public String deleteMember(Model model) {		
		return "deleteMember.jsp";
	}	
	@GetMapping("/error")
	public String error(Model model) {		
		return "error.jsp";
	}
}
