package com.briup.Service.Impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.briup.Bean.Order;
import com.briup.Bean.Orderline;
import com.briup.Bean.Payway;
import com.briup.Bean.User;
import com.briup.Dao.IOrderDaoMapper;
import com.briup.Service.IOrderService;
import com.briup.common.exception.ServiceException;
import com.briup.common.util.MyBatisSqlSessionFactory;

public class IOrderServiceImpl implements IOrderService{
	public IOrderDaoMapper getIOrderDaoMapper() {
		SqlSession session = MyBatisSqlSessionFactory.openSession(true);
		return session.getMapper(IOrderDaoMapper.class);
	}

	@Override
	public List<Order> listOrdersOfUser(User user) throws ServiceException {
		// TODO Auto-generated method stub
		IOrderDaoMapper dao = getIOrderDaoMapper();
		return dao.selectOrderOfUser(user);
	}

	@Override
	public void removeOrder(Integer orderid) throws ServiceException {
		// TODO Auto-generated method stub
		IOrderDaoMapper dao = getIOrderDaoMapper();
		dao.removeOrderByOrderid(orderid);
	}

	@Override
	public void saveOrder(Order order) throws ServiceException {
		// TODO Auto-generated method stub
		IOrderDaoMapper dao = getIOrderDaoMapper();
		dao.insertOrder(order);
	}

	@Override
	public Map<Integer, Payway> listAllPayways() throws ServiceException {
		// TODO Auto-generated method stub
		IOrderDaoMapper dao = getIOrderDaoMapper();
		List<Payway> list = dao.selectAllPayway();
		Map<Integer, Payway> payways = new HashMap<>();
		for (Payway payway : list) {
			payways.put(payway.getPaywayid(), payway);
		}
		return payways;
	}

	@Override
	public Order listOrderByOrderid(Integer orderid) throws ServiceException {
		// TODO Auto-generated method stub
		IOrderDaoMapper dao = getIOrderDaoMapper();
		return dao.selectOrderByOrderid(orderid);
	}
	
	public Integer getOrderId(){
		IOrderDaoMapper dao = getIOrderDaoMapper();
		return dao.getOrderid();
	}
	
	public void saveOrderlines(Iterator<Orderline> orderlines, Order order){
		IOrderDaoMapper dao = getIOrderDaoMapper();
		while(orderlines.hasNext()) {
            Orderline orderline = (Orderline)orderlines.next();
            orderline.setOrder(order);
            dao.insertOrderline(orderline);
		}
		
	}

	public List<Orderline> selectOrderlinesOfOrderid(Integer orderid){
		IOrderDaoMapper dao = getIOrderDaoMapper();
		return dao.selectOrderlinesOfOrderid(orderid);
	}
}
