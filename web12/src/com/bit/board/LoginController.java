package com.bit.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.boardvo.BoardDao;
import com.bit.boardvo.MemberVO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login.bit")
public class LoginController extends HttpServlet {
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
	
	String id = request.getParameter("id").trim();
	String password = request.getParameter("password").trim();
	
	
			PrintWriter out = response.getWriter();
			BoardDao dao = new BoardDao();
			MemberVO bean = dao.login(id, password);
			//int level = bean.getLvl();
			System.out.println("loginLEV="+bean.getLvl());
			if(bean.getId()==null||bean.getPassword()==null) {
				out.print("<logins>");
				out.print("<login>");
				out.print("<id></id>");
				out.print("<lvl></lvl>");
				out.print("</login>");
				out.print("</logins>");	
				return;
			}
			
			out.print("<logins>");
			out.print("<login>");
			out.print("<id>"+bean.getId()+"</id>");
			out.print("<lvl>"+bean.getLvl()+"</lvl>");
			out.print("</login>");
			out.print("</logins>");
			
		//	request.getRequestDispatcher("/index.html").forward(request, response);
	
		
		
	}

}
