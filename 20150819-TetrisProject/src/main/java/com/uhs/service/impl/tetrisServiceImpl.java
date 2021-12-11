package com.uhs.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uhs.dao.rankDao;
import com.uhs.dao.userDao;
import com.uhs.dto.authUser;
import com.uhs.dto.checkExistRank;
import com.uhs.dto.userRankInfo;
import com.uhs.service.tetrisService;

@Service
public class tetrisServiceImpl implements tetrisService{	
	@Autowired
	userDao userDao;
	
	@Autowired
	rankDao rankDao;
	
	@Override
	@Transactional(readOnly = false)
	public authUser addUserInfo(authUser authUser) {
		authUser.setCreateDate(new Date());
		authUser.setModifyDate(new Date());
		Long id = userDao.insert(authUser);

		return authUser;
	}
	
	@Override
	@Transactional(readOnly = false)
	public long updateMemberPassword(String choiceId, String choicePw) {
		long id = userDao.update(choiceId, choicePw);
		return id;
	}
	
	@Override
	@Transactional(readOnly = false)
	public long deleteMember(String choiceId) {
		long id = userDao.delete(choiceId);
		return id;
	}
	
	@Override
	public int userCount(String choiceId) {		
		return userDao.selectUserCount(choiceId);		
	}
	
	@Override
	public int getCheckExistUserCount(String choiceId, String choiceEmail, String choiceLastName,
			String choiceFirstName) {
		return userDao.selectCheckExistUserCount(choiceId, choiceEmail, choiceLastName, choiceFirstName);
	}
	
	@Override
	public List<authUser> getUserInfo(String choiceId) {
		List<authUser> list = userDao.selectUserLogin(choiceId);
		return list;
	}
	
	@Override
	@Transactional(readOnly = false)
	public userRankInfo addRankInfo(userRankInfo userRankInfo) {
		userRankInfo.setCreateDate(new Date());
		userRankInfo.setModifyDate(new Date());
		Long id = rankDao.insert(userRankInfo);

		return userRankInfo;
	}
	
	@Override
	@Transactional(readOnly = false)
	public int updateRankInfo(String choiceId, int choiceScore) {
		int id = (int) rankDao.update(choiceId, choiceScore);
		return id;
	}

	@Override
	public List<userRankInfo> getRankAll() {
		List<userRankInfo> list = rankDao.selectRankAll();
		return list;
	}

	@Override
	public List<checkExistRank> getCheckExistUser(String choiceId) {
		List<checkExistRank> list = rankDao.selectCheckExistUser(choiceId);
		return list;
	}
}
