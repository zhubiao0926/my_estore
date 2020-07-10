package com.briup.Web.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.briup.Bean.Order;
import com.briup.Service.Impl.IOrderServiceImpl;
import com.briup.common.exception.ServiceException;

@WebFilter("/user/orderinfo.jsp")
public class OrderInfoFilter implements Filter {

	public OrderInfoFilter(){
		// TODO Auto-generated constructor stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		IOrderServiceImpl iosi = new IOrderServiceImpl();

		Order order;
		try {
			order = iosi.listOrderByOrderid(Integer.decode(request
					.getParameter("orderid")));
			request.setAttribute("order", order);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
