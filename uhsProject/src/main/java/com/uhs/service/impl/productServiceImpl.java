package com.uhs.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uhs.dao.ProductRepository;
import com.uhs.dto.Product;
import com.uhs.service.productService;

@Service
public class productServiceImpl implements productService {

	@Autowired
	ProductRepository productDao;
	
	@Override
	public List<Product> getProductAll() {
		List<Product> list = productDao.selectProductAll();
		return list;
	}
	
	@Override
	public List<Product> getProductChoice(long choiceId) {
		List<Product> list = productDao.selectProductChoice(choiceId);
		return list;
	}
	
	@Override
	@Transactional(readOnly = false)
	public Product addProductInfo(Product product) {
		product.setModifyDate(new Date());
		product.setCreateDate(new Date());
		Long id = productDao.insert(product);

		return product;
	}

}
