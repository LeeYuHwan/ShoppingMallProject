package com.uhs.dao;

public class rankSql {
	public static final String SELECT_RANK_ALL = "SELECT * FROM total_ranking ORDER BY score DESC";
	public static final String SELECT_CHECK_EXIST_USER = "SELECT IFNULL(score, 0) AS score, COUNT(*) AS count FROM total_ranking WHERE username = :choiceId";
	public static final String UPDATE_RANK_INFO = "UPDATE total_ranking SET score = :choiceScore, modify_date = NOW(3) WHERE username = :choiceId";
}
