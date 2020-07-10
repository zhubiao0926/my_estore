package com.briup.Web.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.Bean.Order;
import com.briup.Bean.OrderStatus;
import com.briup.Bean.Payway;
import com.briup.Bean.ShopCart;
import com.briup.Bean.User;
import com.briup.Service.Impl.IOrderServiceImpl;
import com.briup.common.exception.ServiceException;

@WebServlet("/SaveOrderSer")
public class SaveOrderSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		IOrderServiceImpl iosi = new IOrderServiceImpl();
		try {
			Payway payway = iosi.listAllPayways().get(Integer.decode(request.getParameter("payway")));
			OrderStatus status = new OrderStatus();
			User user = (User) request.getSession().getAttribute("user");
			Order order = new Order();
			ShopCart sc = (ShopCart) request.getSession().getAttribute("shopcart");
			Integer orderId = iosi.getOrderId();
			String cardno = "";
			String orderId1 = orderId+"";
			for (int i = 0; i <=8-orderId1.length(); i++) {
				if (i==8-orderId1.length()) {
					cardno+=orderId1;
				} else {
					cardno+="0";
				}
			}
			System.out.println(cardno);
			status.setStatusid(1);
			order.setOrderid(orderId);
			order.setName("order");
			order.setFinished(1);
			order.setCost(sc.getTotalPrice().doubleValue());
			order.setCardno(cardno);
			order.setUser(user);
			order.setStatus(status);
			order.setPayway(payway);
			
			iosi.saveOrder(order);
			iosi.saveOrderlines(sc.getOrderlines(), order);
			
			ShopCart shopcart = new ShopCart();
			request.getSession().removeAttribute("shopcart");
			request.getSession().setAttribute("shopcart", shopcart);
			response.sendRedirect("OrderSer");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
