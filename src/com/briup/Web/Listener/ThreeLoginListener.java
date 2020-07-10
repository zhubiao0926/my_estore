package com.briup.Web.Listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class ThreeLoginListener implements HttpSessionListener {

    public ThreeLoginListener() {
        // TODO Auto-generated constructor stub
    }

    public void sessionCreated(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    	int failcount = 0;
    	arg0.getSession().setAttribute("failcount", failcount);
    }

    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    }
	
}
