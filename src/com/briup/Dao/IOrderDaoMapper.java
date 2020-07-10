package com.briup.Dao;

import java.util.List;

import com.briup.Bean.Order;
import com.briup.Bean.Orderline;
import com.briup.Bean.Payway;
import com.briup.Bean.User;

public interface IOrderDaoMapper {
	List<Payway> selectAllPayway();
	
	List<Order> selectOrderOfUser(User user);
	
	void removeOrderByOrderid(Integer orderid);
	
	void insertOrder(Order order);
	
	Order selectOrderByOrderid(Integer orderid);
	
	void insertOrderline(Orderline orderline);
	
	Integer getOrderid();
	
	List<Orderline> selectOrderlinesOfOrderid(Integer orderid);
}
