package com.bitjeju.login.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitjeju.member.model.MemberDao;
import com.bitjeju.member.model.MemberDto;

@WebServlet("/login.bit")
public class LoginController extends HttpServlet {
	HttpSession session;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/xml;charset=utf-8");
		
		String id=request.getParameter("emailid");
		String password=request.getParameter("pw");
		System.out.println("id="+id +"pw="+password);
		
		if(id==null||password==null){
			request.setAttribute("login", null);
			request.setAttribute("loginFail", "fail");
			if(session!=null){
				session.invalidate();
			}
			request.getRequestDispatcher("main.jsp").forward(request, response);
			return;
		}
		
		MemberDao dao=new MemberDao();
		MemberDto bean=null;
		
		try {
			bean=dao.loginValidation(id, password);
			System.out.println(bean.getId_email());
			if(bean.getId_email().equals("fail")){
				PrintWriter out=response.getWriter();
				out.print("<loginfail><fail>fail</fail></loginfail>");
				out.close();
				return;
			}
			session=request.getSession();
			session.setAttribute("login",bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

}













