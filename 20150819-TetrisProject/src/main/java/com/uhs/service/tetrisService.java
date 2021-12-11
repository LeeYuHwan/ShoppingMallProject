package com.uhs.service;

import java.util.List;

import com.uhs.dto.authUser;
import com.uhs.dto.checkExistRank;
import com.uhs.dto.userRankInfo;

public interface tetrisService {
	public authUser addUserInfo(authUser authUser);
	public long updateMemberPassword(String choiceId, String choicePw);
	public long deleteMember(String choiceId);
	public int userCount(String choiceId);
	public int getCheckExistUserCount(String choiceId, String choiceEmail, String choiceLastName, String choiceFirstName);
	public List<authUser> getUserInfo(String choiceId);
	
	public userRankInfo addRankInfo(userRankInfo userRankInfo);
	public int updateRankInfo(String choiceId, int choiceScore);
	public List<userRankInfo> getRankAll();
	public List<checkExistRank> getCheckExistUser(String choiceId);
}
