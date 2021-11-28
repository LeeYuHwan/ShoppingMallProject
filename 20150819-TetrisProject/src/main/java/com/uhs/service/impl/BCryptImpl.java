package com.uhs.service.impl;

import org.mindrot.jbcrypt.BCrypt;

import com.uhs.service.EncryptHelper;

public class BCryptImpl implements EncryptHelper {
	@Override
	public String encrypt(String password) {
		// TODO Auto-generated method stub
		return BCrypt.hashpw(password, BCrypt.gensalt()); 
	}

	@Override
	public boolean isMatch(String password, String hashed) {
		// TODO Auto-generated method stub
		return BCrypt.checkpw(password, hashed);
	}
}
