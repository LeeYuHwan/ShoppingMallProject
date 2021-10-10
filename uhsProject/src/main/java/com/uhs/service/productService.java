package com.uhs.service;

import java.util.List;

import com.uhs.dto.Product;

public interface productService {
	public List<Product> getProductAll();
	public Product addProductInfo(Product product);
}
