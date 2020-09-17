package com.bitjeju.teacher.stu.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitjeju.member.model.MemberDto;
import com.bitjeju.teacher.stu.model.StudentDao;

@WebServlet("/lmsteacherstulist.bit")
public class StuListController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				String key = null;
				String word = null;
				try {
					key = request.getParameter("key"); 
					word = new String(request.getParameter("word").getBytes("iso-8859-1"), "utf-8");
				} catch (NullPointerException e) {
				} finally {
					if (key == null || key.trim() == "")
						key = "name";
					if (word == null || word.trim() == "")
						word = "";
				} // finally 
					
				//key lecture or name
				
				int pageNum;
				int totalStudent=-1;
				if (request.getParameter("pageNum") != null) {
					System.out.println(request.getParameter("pageNum"));
					pageNum = Integer.parseInt(request.getParameter("pageNum").trim());
				}else {
					pageNum=1;
				}
				
				ArrayList<MemberDto> list = null;
				try {
					StudentDao dao = new StudentDao();
					list = dao.stuSelectAll(pageNum, key, word);
						dao = new StudentDao();
						totalStudent = dao.totalStudent(key, word); 
								
				} catch (SQLException e) {
					e.printStackTrace();
				}
				request.setAttribute("pageNum", pageNum);
				request.setAttribute("totalStudent", totalStudent); 
				request.setAttribute("list", list); 
				request.getRequestDispatcher("teacherStudList.jsp").forward(request, response);
	}

}
