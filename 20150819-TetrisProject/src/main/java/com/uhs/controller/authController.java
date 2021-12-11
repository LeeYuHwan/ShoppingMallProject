package com.uhs.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uhs.dto.authUser;
import com.uhs.dto.changePwTmp;
import com.uhs.factory.userFactory;
import com.uhs.service.EncryptHelper;
import com.uhs.service.tetrisService;

@RestController
@RequestMapping(path="/api/auth")
public class authController {
	
	@Autowired
	private tetrisService tetrisService;
	
	@Autowired
	private EncryptHelper encryptHelper;
	
	@PostMapping
	public String addUserInfoCon(HttpServletRequest request) {
		String returnUrl = "";
		JSONObject response = new JSONObject();
		try {
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String email = request.getParameter("email");
			String username = request.getParameter("username");
			
			int check = tetrisService.userCount(username);
			
			if(check > 0) {
				returnUrl = "./error";
				response.put("returnUrl", returnUrl);
				response.put("status", false);
				response.put("message", "These are duplicated ID.");
				
				return response.toString();
			}
			
			String password = encryptHelper.encrypt(request.getParameter("password"));
			
			authUser authUser = new userFactory().makeUser(new authUser(), firstname, lastname, email, username, password);
			tetrisService.addUserInfo(authUser);
			
			
			returnUrl = "./login";
			response.put("returnUrl", returnUrl);
			response.put("status", true);
			response.put("message", "registration completed.");
		}
		catch (Exception e) {
			e.printStackTrace();
			returnUrl = "./error";
			response.put("returnUrl", returnUrl);
			response.put("status", false);
			response.put("message", "Error.");
		}
		
		return response.toString();
	}
	
	@PostMapping("/login")
	public String loginCheckCon(HttpServletRequest request, HttpSession session) {
		String returnUrl = "";
		JSONObject response = new JSONObject();
		try {
			String username = request.getParameter("username");		
			
			List<authUser> authUser = tetrisService.getUserInfo(username);
			if(authUser.size() == 0) {
				returnUrl = "./login";
				response.put("returnUrl", returnUrl);
				response.put("status", true);
				response.put("message", "Check your ID.");
				
				return response.toString();
			}
			
			String checkPw = authUser.get(0).getPassword();	
			String password = request.getParameter("password");
			
			if(encryptHelper.isMatch(password, checkPw)) {
				returnUrl = "./title";
				response.put("returnUrl", returnUrl);
				response.put("status", true);
				response.put("message", "LogIn Success.");
				
				session.setAttribute("id", username);
			}
			else {
				returnUrl = "./login";
				response.put("returnUrl", returnUrl);
				response.put("status", false);
				response.put("message", "Check your password.");
			}				
		}
		catch (Exception e) {
			e.printStackTrace();
			returnUrl = "./error";
			response.put("returnUrl", returnUrl);
			response.put("status", false);
			response.put("message", "Error.");
		}
		
		return response.toString();
	}
	
	@PostMapping("/withdrawal")
	public String deleteMemberCon(HttpServletRequest request, HttpSession session) {
		String returnUrl = "";
		JSONObject response = new JSONObject();
		try {			

			String username = request.getParameter("username");
			List<authUser> authUser = tetrisService.getUserInfo(username);

			String checkPw = authUser.get(0).getPassword();	
			String password = request.getParameter("password");
			
			if(encryptHelper.isMatch(password, checkPw)) {
				long deleteMember = tetrisService.deleteMember(username);
				
				returnUrl = "./logout";
				response.put("returnUrl", returnUrl);
				response.put("status", true);
				response.put("message", "Successful Withdrawal!");
			}
			else {
				returnUrl = "./delete-member";
				response.put("returnUrl", returnUrl);
				response.put("status", false);
				response.put("message", "Check your password.");
			}						
		}
		catch (Exception e) {
			e.printStackTrace();
			returnUrl = "./logout";
			response.put("returnUrl", returnUrl);
			response.put("status", false);
			response.put("message", "Error.");
		}
		
		return response.toString();
	}
	
	@GetMapping
	public String findUserCon(HttpServletRequest request, HttpSession session) {
		String returnUrl = "";
		JSONObject response = new JSONObject();
		try {
			
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String email = request.getParameter("email");
			String id = request.getParameter("id");
			
			int check = tetrisService.getCheckExistUserCount(id, email, lastname, firstname);
			
			if(check > 0) {			
				
				session.setAttribute("changeId", id);
				
				returnUrl = "./changepw";
				response.put("returnUrl", returnUrl);
				response.put("message", "Enter the password you want to change.");
				response.put("status", true);
			}
			else {
				returnUrl = "./login";
				response.put("returnUrl", returnUrl);
				response.put("message", "Check the information again...");
				response.put("status", true);
			}			
		}
		catch (Exception e) {
			e.printStackTrace();
			returnUrl = "./error";
			response.put("returnUrl", returnUrl);
			response.put("status", false);
			response.put("message", "Error.");
		}
		
		return response.toString();
	}
	
	@PutMapping
	public String changePassWordCon(@RequestBody changePwTmp changePwTmp, HttpSession session) {
		String returnUrl = "";
		JSONObject response = new JSONObject();
		try {			
			
			String inputPassword = encryptHelper.encrypt(changePwTmp.getPassword());			
			long changePw = tetrisService.updateMemberPassword(changePwTmp.getUsername(), inputPassword);
								
			returnUrl = "./logout";
			response.put("returnUrl", returnUrl);
			response.put("status", true);
			response.put("message", "Successful change!");
		}
		catch (Exception e) {
			e.printStackTrace();
			returnUrl = "./logout";
			response.put("returnUrl", returnUrl);
			response.put("status", false);
			response.put("message", "Error.");
		}
		
		return response.toString();
	}
}
