package com.uhs.service;

import java.util.List;

import com.uhs.dto.Product;
import com.uhs.dto.Shipping;

public interface productService {
	public List<Product> getProductAll();
	public List<Product> getProductChoice(long id);
	public Product addProductInfo(Product product);
	public Shipping addShippingInfo(Shipping shipping);
}
