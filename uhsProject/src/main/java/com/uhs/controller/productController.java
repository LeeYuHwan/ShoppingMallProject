package com.uhs.controller;

import java.io.FileOutputStream;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.uhs.dto.Product;
import com.uhs.service.productService;

@Controller
public class productController {
	@Autowired
	productService productService;
	
	@PostMapping(path = "/registration")
	public String registration(MultipartHttpServletRequest request) {	
			
		System.out.println("상품 insert 실행 : " + request);				
		
		Product product = new Product();
		MultipartFile file = request.getFile("file");
		
		if(!file.isEmpty()) {
			System.out.println("파일 이름 : " + file.getOriginalFilename());
			System.out.println("파일 크기 : " + file.getSize());
			try(
		    		// 맥일 경우 
		            //FileOutputStream fos = new FileOutputStream("C:/Users/이유환/eclipse-workspace/uhsProject/src/main/webapp/resources/img/" + file.getOriginalFilename());
		            // 윈도우일 경우
		            FileOutputStream fos = new FileOutputStream("C:/Users/이유환/eclipse-workspace/uhsProject/src/main/webapp/resources/img/" + file.getOriginalFilename());
		            InputStream is = file.getInputStream();
		    ){
		        	int readCount = 0;
		        	byte[] buffer = new byte[1024];
		        	while((readCount = is.read(buffer)) != -1){
		                fos.write(buffer,0,readCount);
		            }
		    }catch(Exception ex){
		        throw new RuntimeException("file Save Error");
		    }
			product.setImgName(file.getOriginalFilename());
		}
		else {
			System.out.println("이미지 없이 comment 삽입");
			product.setImgName(null);
		}
		
		product.setProductId(request.getParameter("productId"));
		product.setPname(request.getParameter("pname"));
		product.setUnitPrice(Integer.parseInt(request.getParameter("unitPrice")));
		product.setDescription(request.getParameter("description"));
		product.setManufacturer(request.getParameter("manufacturer"));
		product.setCategory(request.getParameter("category"));
		product.setUnitsInstock(Long.parseLong(request.getParameter("unitsInstock"))); 
		product.setPcondition(request.getParameter("pcondition"));
		 		
		productService.addProductInfo(product);
						
		return "redirect:./product";
	}
}

