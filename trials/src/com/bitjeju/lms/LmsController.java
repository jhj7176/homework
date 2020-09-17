package com.bitjeju.lms;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitjeju.member.model.MemberDto;

@WebServlet("/lms.bit")
public class LmsController extends HttpServlet {
	HttpSession session;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession(false);
		MemberDto bean=(MemberDto) session.getAttribute("login");
		String dept=bean.getDept();
		int loginlevel=bean.getLvl();
		System.out.println(loginlevel);
		
		if(dept.equals("영업")){
			response.sendRedirect("lmssalesassign.bit");
			return;
		}else if(dept.equals("행정")){
			request.getRequestDispatcher("sales.jsp").forward(request, response);
			return;
		}else if(dept.equals("강사")){
			response.sendRedirect("lmsteacherattendance.bit");
			return;
		}else if(dept.equals("수강생")){
			response.sendRedirect("lmsstugrade.bit");
			return;
		}else{
		System.out.println("lms controller");	
			
		}
		request.getRequestDispatcher("main.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
