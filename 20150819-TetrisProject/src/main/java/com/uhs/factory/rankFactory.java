package com.uhs.factory;

import com.uhs.dto.userRankInfo;

public class rankFactory {
	public userRankInfo makeRank(userRankInfo userRankInfo, String username, int score) {		
		
		userRankInfo.setUsername(username);
		userRankInfo.setScore(score);
		
		return userRankInfo;
	}
}
