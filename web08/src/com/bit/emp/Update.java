package com.bit.emp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Update extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("EUC-KR");
			
		String param1 = req.getParameter("sabun");
		String param2 = req.getParameter("name");
		String param3 = req.getParameter("pay");
	
		int sabun = Integer.parseInt(param1.trim());
		int pay = Integer.parseInt(param3.trim());
		String name = param2.trim();
		
		com.bit.emp.EmpSQL.update(sabun, name, pay);
		resp.sendRedirect("list.jsp");
		
	}

}
