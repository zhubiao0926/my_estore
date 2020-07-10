package com.briup.Web.Listener;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.briup.Bean.Product;
import com.briup.Service.Impl.IProductServiceImpl;
import com.briup.common.exception.ServiceException;

@WebListener
public class ApplicationListener implements ServletContextListener {

    public ApplicationListener() {
        // TODO Auto-generated constructor stub
    }

    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	ServletContext application = arg0.getServletContext();
    	try {
			Map<String, Product> products = new IProductServiceImpl().listAllProducts();
			application.setAttribute("products", products);
			System.out.println("书库载入成功");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
}
