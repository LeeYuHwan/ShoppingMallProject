package com.uhs.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.uhs.dto.Product;

@Repository
public class ProductRepository {
	
	public static ArrayList<Product> ListOfProducts(){
		ArrayList<Product> listOfProducts = new ArrayList<Product>();
		
		Product phone = new Product("P1234", "아이폰 6s", 800000);
		phone.setDescription("크기 : 4.7인치, 1334X750 레티나 HD 디스플레이, 8백만화소 카메라");
		phone.setCategory("스마트폰");
		phone.setManufacturer("애플");
		phone.setUnitsInstock((long)1000);
		phone.setCondition("New");
		
		Product notebook = new Product("P1235", "LG PC 그램", 1500000);
		notebook.setDescription("크기 : 13.3인치, IPS LED 디스플레이, 5세대 인텔 코어 CPU 프로세서");
		notebook.setCategory("노트북");
		notebook.setManufacturer("LG");
		notebook.setUnitsInstock((long)1000);
		notebook.setCondition("Refurbished");
		
		Product tablet = new Product("P1236", "갤럭시 탭 S", 900000);
		tablet.setDescription("크기 : 212.8*125.6*6.6mm, 슈퍼 아몰레드 디스플레이, 옥타 코어 CPU");
		tablet.setCategory("태블릿");
		tablet.setManufacturer("삼성");
		tablet.setUnitsInstock((long)1000);
		tablet.setCondition("Old");
		
		listOfProducts.add(phone);
		listOfProducts.add(notebook);
		listOfProducts.add(tablet);
		
		return listOfProducts;
	}
	
}
