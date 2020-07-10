package com.briup.Web.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.Bean.Order;
import com.briup.Bean.Orderline;
import com.briup.Service.Impl.IOrderServiceImpl;
import com.briup.common.exception.ServiceException;

@WebServlet("/OrderInfoSer")
public class OrderInfoSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		IOrderServiceImpl iosi = new IOrderServiceImpl();
		Integer orderid = Integer.decode(request.getParameter("orderid"));
		try {
			Order order = iosi.listOrderByOrderid(orderid);
			List<Orderline> orderlines = iosi.selectOrderlinesOfOrderid(orderid);
			
			request.setAttribute("order", order);
			request.setAttribute("orderlines", orderlines);
			request.getRequestDispatcher("user/orderinfo.jsp").include(request, response);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
