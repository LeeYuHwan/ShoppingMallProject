package com.uhs.service;

import java.util.List;

import com.uhs.dto.authUser;

public interface tetrisService {
	public authUser addUserInfo(authUser authUser);
	public int userCount(String choiceId);
	public List<authUser> getUserInfo(String choiceId);
}
