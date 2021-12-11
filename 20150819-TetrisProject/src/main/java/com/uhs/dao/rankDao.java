package com.uhs.dao;

import static com.uhs.dao.rankSql.SELECT_CHECK_EXIST_USER;
import static com.uhs.dao.rankSql.SELECT_RANK_ALL;
import static com.uhs.dao.rankSql.UPDATE_RANK_INFO;

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

import com.uhs.dto.checkExistRank;
import com.uhs.dto.userRankInfo;

@Repository
public class rankDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<userRankInfo> rowMapper = BeanPropertyRowMapper.newInstance(userRankInfo.class);
	private RowMapper<checkExistRank> checkRowMapper = BeanPropertyRowMapper.newInstance(checkExistRank.class);
	
	public rankDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("total_ranking")
				.usingGeneratedKeyColumns("id");
	}

	public List<checkExistRank> selectCheckExistUser(String choiceId) {
		Map<String, ?> params = Collections.singletonMap("choiceId", choiceId);
		return jdbc.query(SELECT_CHECK_EXIST_USER, params, checkRowMapper);
	}
	
	public List<userRankInfo> selectRankAll() {
		return jdbc.query(SELECT_RANK_ALL, Collections.emptyMap(), rowMapper);
	}
	
	public long insert(userRankInfo userRankInfo) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(userRankInfo);
		return insertAction.executeAndReturnKey(params).intValue();
	}
	
	public long update(String choiceId, int choiceScore) {		
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("choiceId", choiceId);
		params.put("choiceScore", choiceScore);
		
		return jdbc.update(UPDATE_RANK_INFO, params);
	}
}
