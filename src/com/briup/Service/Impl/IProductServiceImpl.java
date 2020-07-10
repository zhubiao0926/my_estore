package com.briup.Service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.briup.Bean.Product;
import com.briup.Dao.IProductDaoMapper;
import com.briup.Service.IProductService;
import com.briup.common.exception.ServiceException;
import com.briup.common.util.MyBatisSqlSessionFactory;

public class IProductServiceImpl implements IProductService{
	public IProductDaoMapper getIProductDaoMapper() {
		SqlSession session = MyBatisSqlSessionFactory.openSession(true);
		return session.getMapper(IProductDaoMapper.class);
	}

	@Override
	public Map<String,Product> listAllProducts() throws ServiceException {
		// TODO Auto-generated method stub
		IProductDaoMapper dao = getIProductDaoMapper();
		List<Product> list = dao.selectAllProduct();
		Map<String, Product> products = new HashMap<>();
		if (list.size()>0) {
			for (Product product : list) {
				products.put(product.getProductid()+"", product);
			}
			return products;
		} else {
			return null;
		}
	}

	@Override
	public Product getProductByProductid(Integer productid)
			throws ServiceException {
		// TODO Auto-generated method stub
		IProductDaoMapper dao = getIProductDaoMapper();
		return dao.selectProductByProductid(productid);
	}

}
