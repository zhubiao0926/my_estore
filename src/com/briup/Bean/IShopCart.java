package com.briup.Bean;

import java.math.BigDecimal;
import java.util.Iterator;

public interface IShopCart {
	
	void addProduct(Product product) throws Exception;
	
	void removeProduct(Integer productid) throws Exception;
	
	void removeAllProducts() throws Exception;
	
	void updateProduct(Integer productid,Integer number) throws Exception;
	
	BigDecimal getTotalPrice() throws Exception;
	
	Iterator<Orderline> getOrderlines() throws Exception;
	
}






