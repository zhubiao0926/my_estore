package com.briup.Web.Filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.briup.Bean.Order;
import com.briup.Bean.ShopCart;
import com.briup.Bean.User;
import com.briup.Service.Impl.IOrderServiceImpl;
import com.briup.Service.Impl.IUserServiceImpl;
import com.briup.common.exception.ServiceException;

@WebFilter(urlPatterns={"/login.jsp"})
public class LoginAutoFilter implements Filter {

    public LoginAutoFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		//String uri = req.getRequestURI();
		// 获取Cookie
		Cookie[] cookies = req.getCookies();
		Map<String, String> map = new HashMap<>();
		
		if (cookies!=null) {
			for (Cookie cookie : cookies) {
				map.put(cookie.getName(), cookie.getValue());
			}
			if (map.containsKey("userid")&&map.containsKey("password")) {
				User user;
				try {
					user = new IUserServiceImpl().login(map.get("userid"), map.get("password"));
					ShopCart shopcart = new ShopCart();
					List<Order> orders = new IOrderServiceImpl().listOrdersOfUser(user);
					req.getSession().setAttribute("shopcart", shopcart);
					req.getSession().setAttribute("user", user);
					req.getSession().setAttribute("orders", orders);
					req.getSession().setMaxInactiveInterval(3600);
					
					// 注意，一旦跳转了不能再执行chain.doFilter(request, response);	否则报错
					req.getRequestDispatcher("/index.jsp").include(req, response);
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				}
			} else {
				chain.doFilter(request, response);	
			}
		} else {
			// pass the request along the filter chain
			chain.doFilter(request, response);			
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
