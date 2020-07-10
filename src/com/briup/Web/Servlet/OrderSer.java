package com.briup.Web.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.Bean.Order;
import com.briup.Bean.User;
import com.briup.Service.Impl.IOrderServiceImpl;
import com.briup.common.exception.ServiceException;

@WebServlet("/OrderSer")
public class OrderSer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getSession().removeAttribute("orders");
		
		try {
			User user = (User)request.getSession().getAttribute("user");
			List<Order> orders = new IOrderServiceImpl().listOrdersOfUser(user);
			request.getSession().setAttribute("orders", orders);
			request.getRequestDispatcher("user/order.jsp").include(request, response);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
