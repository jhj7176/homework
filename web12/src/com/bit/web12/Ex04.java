package com.bit.web12;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex04 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		resp.setContentType("application/xml; charset=utf-8");
		String id = req.getParameter("id");
		PrintWriter out = resp.getWriter();
		/*
		 * out.print(id+"님 환영합니다."); out.println("ex04.java service");
		 */
		out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		out.println("<students>");
		
		for (int i = 0; i < 5; i++) {
			
		out.println("<student>");
		out.println("<num>"+(i+1)+"</num>");
		out.println("<name>user"+(i+1)+"</name>");
		out.println("<kor>"+((Math.random()*100)/100*100)+"</kor>");
		out.println("<eng>"+((Math.random()*100)/100*100)+"</eng>");
		out.println("<math>"+((Math.random()*100)/100*100)+"</math>");
		out.println("</student>");
		}
		
		out.println("</students>");
		
		
		
		out.close();
		
	}
	
	
}
