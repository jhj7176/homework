package com.bitjeju.login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout.bit")
public class LogoutController extends HttpServlet {
	HttpSession session;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("login", null);
		session=request.getSession(false);
		if(session!=null){
			session.invalidate();
		}
		
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

}
