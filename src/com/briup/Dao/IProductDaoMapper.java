package com.briup.Dao;

import java.util.List;

import com.briup.Bean.Product;

public interface IProductDaoMapper {
	List<Product> selectAllProduct();
	Product selectProductByProductid(Integer integer);
}
