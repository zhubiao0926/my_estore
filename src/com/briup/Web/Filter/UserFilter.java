package com.briup.Web.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.briup.Bean.User;

@WebFilter(urlPatterns={"/user/*","/AddProductSer"})
public class UserFilter implements Filter {

    public UserFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		String url = req.getRequestURI();
		User user = (User)req.getSession().getAttribute("user");
		if (user!=null) {
			// pass the request along the filter chain
			chain.doFilter(request, response);
		} else {
			request.getRequestDispatcher("/login.jsp").include(request, response);
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
