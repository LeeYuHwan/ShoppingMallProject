package com.uhs.dao;

import static com.uhs.dao.userSql.DELETE_MEMBER;
import static com.uhs.dao.userSql.SELECT_CHECK_EXIST_USER_COUNT;
import static com.uhs.dao.userSql.SELECT_USER_COUNT;
import static com.uhs.dao.userSql.SELECT_USER_INFO;
import static com.uhs.dao.userSql.UPDATE_MEMBER_PASSWORD;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.uhs.dto.authUser;

@Repository
public class userDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<authUser> rowMapper = BeanPropertyRowMapper.newInstance(authUser.class);
	
	public userDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("user_info")
				.usingGeneratedKeyColumns("id");
	}
	
	public int selectUserCount(String choiceId) {
		Map<String, ?> params = Collections.singletonMap("choiceId", choiceId);
		return jdbc.queryForObject(SELECT_USER_COUNT, params, Integer.class);
	}
	
	public int selectCheckExistUserCount(String choiceId, String choiceEmail, String choiceLastName, String choiceFirstName) {
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("choiceId", choiceId);
		params.put("choiceEmail", choiceEmail);
		params.put("choiceLastName", choiceLastName);
		params.put("choiceFirstName", choiceFirstName);
		
		return jdbc.queryForObject(SELECT_CHECK_EXIST_USER_COUNT, params, Integer.class);
	}
	
	public List<authUser> selectUserLogin(String choiceId) {
		Map<String, ?> params = Collections.singletonMap("choiceId", choiceId);
		return jdbc.query(SELECT_USER_INFO, params, rowMapper);
	}
		
	public long insert(authUser authUser) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(authUser);
		return insertAction.executeAndReturnKey(params).intValue();
	}
	
	public long update(String choiceId, String choicePw) {		
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("choiceId", choiceId);
		params.put("choicePw", choicePw);
		
		return jdbc.update(UPDATE_MEMBER_PASSWORD, params);
	}
	
	public long delete(String choiceId) {		
		Map<String, ?> params = Collections.singletonMap("choiceId", choiceId);		
		return jdbc.update(DELETE_MEMBER, params);
	}
}
