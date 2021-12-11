package com.uhs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uhs.dto.checkExistRank;
import com.uhs.dto.userRankInfo;
import com.uhs.factory.rankFactory;
import com.uhs.service.tetrisService;

@RestController
@RequestMapping(path="/api/rank")
public class rankController {
	
	@Autowired
	private tetrisService tetrisService;
		
	@PostMapping
	public String addUserScoreCon(HttpServletRequest request) {
		String returnUrl = "";
		JSONObject response = new JSONObject();
		
		try {
			
			String username = request.getParameter("username");
			int score = Integer.parseInt(request.getParameter("score"));
			
			List<checkExistRank> cer = tetrisService.getCheckExistUser(username);
						
			if(cer.get(0).getCount() > 0) {	
				
				if(cer.get(0).getScore() < score) {
					tetrisService.updateRankInfo(username, score);
				}
												
				response.put("message", "Score Update completed.");
			}
			else {				
				userRankInfo userRankInfo = new rankFactory().makeRank(new userRankInfo(), username, score);
				tetrisService.addRankInfo(userRankInfo);
				
				response.put("message", "Score Add completed.");
			}
			
			returnUrl = "./title";
			response.put("returnUrl", returnUrl);
			response.put("status", true);	
		}catch (Exception e) {
			
			e.printStackTrace();
			
			returnUrl = "./error";
			response.put("returnUrl", returnUrl);
			response.put("status", false);
			response.put("message", "Error.");
		}
		
		return response.toString();
	}
	
	@GetMapping
	public Map<String, Object> getUserRankCon(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		
		try {		
			List<userRankInfo> userRankInfos = tetrisService.getRankAll();	
			
			map.put("userRankInfos", userRankInfos);
			map.put("status", true);	
		}catch (Exception e) {			
			e.printStackTrace();
			
			map.put("status", false);
			map.put("message", "Error.");
		}
		
		return map;
	}
}
