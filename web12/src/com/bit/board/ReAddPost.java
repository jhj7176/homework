package com.bit.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.startup.SetContextPropertiesRule;

public class ReAddPost extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String param = req.getParameter("num");
		int num = Integer.parseInt(param);
		String writer = req.getParameter("writer");
		String content = req.getParameter("content");
	
		
		
		
		
	}
}
