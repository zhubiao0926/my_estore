package com.briup.Web.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.Bean.Order;
import com.briup.Bean.ShopCart;
import com.briup.Bean.User;
import com.briup.Service.Impl.IOrderServiceImpl;
import com.briup.Service.Impl.IUserServiceImpl;
import com.briup.common.exception.ServiceException;

@WebServlet("/LoginSer")
public class LoginSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String auto = request.getParameter("auto");
		int failcount = (int) request.getSession().getAttribute("failcount");
		try {
			User user = new IUserServiceImpl().login(userid, password);
			if ("0".equals(auto)) {
				Cookie cookie = new Cookie("userid",userid);
				cookie.setMaxAge(60*60*24*31);
				Cookie cookie1 = new Cookie("password",password);
				cookie1.setMaxAge(60*60*24*31);
				response.addCookie(cookie);
				response.addCookie(cookie1);
			}
			ShopCart shopcart = new ShopCart();
			List<Order> orders = new IOrderServiceImpl().listOrdersOfUser(user);
			request.getSession().setAttribute("shopcart", shopcart);
			request.getSession().setAttribute("user", user);
			request.getSession().setAttribute("orders", orders);
			request.getSession().setMaxInactiveInterval(3600);
			failcount = 0;
			request.getSession().setAttribute("failcount", failcount);
			request.getRequestDispatcher("/index.jsp").include(request, response);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			failcount += 1;
			request.getSession().setAttribute("failcount", failcount);
			if (failcount==3) {
				response.sendRedirect("/register.jsp");
			} else {
				request.setAttribute("msg", e.getMessage());
				request.getRequestDispatcher("/login.jsp").include(request, response);
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
