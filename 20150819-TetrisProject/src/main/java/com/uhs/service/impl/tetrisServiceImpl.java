package com.uhs.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uhs.dao.userDao;
import com.uhs.dto.authUser;
import com.uhs.service.tetrisService;

@Service
public class tetrisServiceImpl implements tetrisService{	
	@Autowired
	userDao userDao;
	
	@Override
	@Transactional(readOnly = false)
	public authUser addUserInfo(authUser authUser) {
		authUser.setCreateDate(new Date());
		authUser.setModifyDate(new Date());
		Long id = userDao.insert(authUser);

		return authUser;
	}
	
	@Override
	public int userCount(String choiceId) {		
		return userDao.selectUserCount(choiceId);		
	}
	
	@Override
	public List<authUser> getUserInfo(String choiceId) {
		List<authUser> list = userDao.selectUserLogin(choiceId);
		return list;
	}
}
