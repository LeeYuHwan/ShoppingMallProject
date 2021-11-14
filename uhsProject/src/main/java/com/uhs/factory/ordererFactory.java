package com.uhs.factory;

import com.uhs.dto.Shipping;

public class ordererFactory {
	public Shipping makeorderer(Shipping shipping, long productId, String name, String shippingDay, String country, 
			String zipCode, String address) {		
		shipping.setProductId(productId);
		shipping.setName(name);
		shipping.setShippingDay(shippingDay);
		shipping.setCountry(country);
		shipping.setZipCode(zipCode);
		shipping.setAddress(address);
		
		return shipping;
	}
}
