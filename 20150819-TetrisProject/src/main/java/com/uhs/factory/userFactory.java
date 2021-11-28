package com.uhs.factory;

import com.uhs.dto.authUser;

public class userFactory {
	public authUser makeUser(authUser authUser, String firstname, String lastname, String email, 
			String username, String password) {		
		
		authUser.setFirstname(firstname);
		authUser.setLastname(lastname);
		authUser.setEmail(email);
		authUser.setUsername(username);
		authUser.setPassword(password);
		
		return authUser;
	}
}
