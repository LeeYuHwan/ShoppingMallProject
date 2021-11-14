package com.uhs.factory;

import java.io.FileOutputStream;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

import com.uhs.dto.Product;

public class productFactory{
	public Product makeProduct(Product product, String ProductId, String pname, int unitPrice, String description, 
			String manufacturer, String category, long unitsInstock, String pcondition, MultipartFile file) {		
		product.setProductId(ProductId);
		product.setPname(pname);
		product.setUnitPrice(unitPrice);
		product.setDescription(description);
		product.setManufacturer(manufacturer);
		product.setCategory(category);
		product.setUnitsInstock(unitsInstock); 
		product.setPcondition(pcondition);
		product = makeFile(product, file);
		
		return product;
	}
	
	private Product makeFile(Product product, MultipartFile file) {
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
		
		return product;
	}
}
