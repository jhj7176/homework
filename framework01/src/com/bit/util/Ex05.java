package com.bit.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Ex05 implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
		System.out.println("listener Destroy");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("listener Init : "+sce.getServletContext().getInitParameter("cmsg"));
	}

}
