package com.briup.Web.Servlet;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.Bean.Orderline;
import com.briup.Bean.ShopCart;

@WebServlet("/ConfirmOrderSer")
public class ConfirmOrderSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ShopCart sc = (ShopCart) request.getSession().getAttribute("shopcart");
		try {
			Iterator<Orderline> iterator = sc.getOrderlines();
			if (iterator.hasNext()) {
				request.getRequestDispatcher("user/confirmOrder.jsp").include(request, response);
			} else {
				response.sendRedirect("index.jsp");
			}
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
