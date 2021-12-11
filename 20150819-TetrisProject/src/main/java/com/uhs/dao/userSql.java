package com.uhs.dao;

public class userSql {
	public static final String SELECT_USER_INFO = "SELECT * FROM user_info WHERE username = :choiceId";
	public static final String SELECT_USER_COUNT = "SELECT COUNT(*) FROM user_info WHERE username = :choiceId";
	public static final String SELECT_CHECK_EXIST_USER_COUNT = "SELECT COUNT(*) FROM user_info WHERE firstname = :choiceFirstName AND lastname = :choiceLastName AND email = :choiceEmail AND username = :choiceId";
	public static final String UPDATE_MEMBER_PASSWORD = "UPDATE user_info SET PASSWORD = :choicePw, modify_date = NOW(3) WHERE username = :choiceId";
	public static final String DELETE_MEMBER = "DELETE FROM user_info WHERE username = :choiceId";
}
