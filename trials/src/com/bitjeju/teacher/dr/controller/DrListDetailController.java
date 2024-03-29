package com.bitjeju.teacher.dr.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitjeju.member.model.MemberDto;
import com.bitjeju.teacher.dr.model.DrDao;
import com.bitjeju.teacher.dr.model.DrDto;


@WebServlet("/lmsteacherdrdetail.bit")
public class DrListDetailController extends HttpServlet {
	HttpSession session;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session=request.getSession(false);
		request.setCharacterEncoding("utf-8");
		MemberDto bean2=(MemberDto) session.getAttribute("login");
		int drNum=Integer.parseInt(request.getParameter("drNum").trim());
		System.out.println("DrListController, drNum: "+drNum);
		try {
			DrDao dao=new DrDao();
			DrDto bean=dao.selectOne(drNum);
			request.setAttribute("bean", bean);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("teacherDataroomDetail.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
