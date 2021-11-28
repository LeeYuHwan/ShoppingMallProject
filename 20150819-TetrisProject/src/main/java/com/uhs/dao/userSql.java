package com.uhs.dao;

public class userSql {
	public static final String SELECT_USER_INFO = "SELECT * FROM user_info WHERE username = :choiceId";
	public static final String SELECT_USER_COUNT = "SELECT COUNT(*) FROM user_info WHERE username = :choiceId";
}
