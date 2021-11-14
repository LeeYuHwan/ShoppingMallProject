package com.uhs.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.uhs.dto.Shipping;

@Repository
public class ordererRepository {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Shipping> rowMapper = BeanPropertyRowMapper.newInstance(Shipping.class);
	
	public ordererRepository(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("shippinginfo")
				.usingGeneratedKeyColumns("id");
	}
	
	public long insert(Shipping shipping) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(shipping);
		return insertAction.executeAndReturnKey(params).intValue();
	}
}
