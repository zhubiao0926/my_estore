package com.briup.Web.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.Bean.Product;
import com.briup.Bean.ShopCart;
import com.briup.Service.Impl.IProductServiceImpl;
import com.briup.common.exception.ServiceException;

@WebServlet("/AddProductSer")
public class AddProductSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer productid = Integer.decode(request.getParameter("productid"));
		try {
			Product product = new IProductServiceImpl().getProductByProductid(productid);
			ShopCart shopcart = (ShopCart) request.getSession().getAttribute("shopcart");
			shopcart.addProduct(product);
			request.getSession().setAttribute("shopcart", shopcart);
			request.getRequestDispatcher("user/shopcart.jsp").include(request, response);
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
