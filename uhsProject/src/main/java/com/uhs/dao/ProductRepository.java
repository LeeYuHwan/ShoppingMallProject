package com.uhs.dao;

import static com.uhs.dao.productSql.SELECT_PRODUCT_ALL;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.uhs.dto.Product;


@Repository
public class ProductRepository {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Product> rowMapper = BeanPropertyRowMapper.newInstance(Product.class);
	
	public ProductRepository(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("productInfo")
				.usingGeneratedKeyColumns("id");
	}
	
	public List<Product> selectProductAll(){
		
		return jdbc.query(SELECT_PRODUCT_ALL, Collections.emptyMap(), rowMapper);		
	}	
	
	public long insert(Product product) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(product);
		return insertAction.executeAndReturnKey(params).intValue();
	}
}
