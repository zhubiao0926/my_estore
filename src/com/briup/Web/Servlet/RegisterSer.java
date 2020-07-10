package com.briup.Web.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.Bean.User;
import com.briup.Service.Impl.IUserServiceImpl;
import com.briup.common.exception.ServiceException;

@WebServlet("/RegisterSer")
public class RegisterSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String country = request.getParameter("country");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String street1 = request.getParameter("street1");
		String street2 = request.getParameter("street2");
		String zip = request.getParameter("zip");
		String homephone = request.getParameter("homephone");
		String officephone = request.getParameter("officephone");
		String cellphone = request.getParameter("cellphone");
		String email = request.getParameter("email");
		User user = new User();
		user.setUserid(userid);
		user.setPassword(password);
		user.setCountry(country);
		user.setProvince(province);
		user.setCity(city);
		user.setStreet1(street1);
		user.setStreet2(street2);
		user.setZip(zip);
		user.setHomephone(homephone);
		user.setOfficephone(officephone);
		user.setCellphone(cellphone);
		user.setEmail(email);
		try {
			new IUserServiceImpl().registerUser(user);
			request.getRequestDispatcher("/login.jsp").include(request, response);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			// 数据库用户已经存在，跳转注册页面重新注册
			request.getRequestDispatcher("/register.jsp").include(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
