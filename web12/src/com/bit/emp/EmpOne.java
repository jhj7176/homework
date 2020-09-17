package com.bit.emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmpOne extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		int empno = Integer.parseInt(req.getParameter("idx"));
		EmpDao	dao = new EmpDao();
		EmpVO bean = dao.getOne(empno);
		PrintWriter out = resp.getWriter();
		out.print("<emp>");
		
		out.print("<worker>");
		out.print("<empno>"+bean.getEmpno()+"</empno>");
		out.print("<ename>"+bean.getEname()+"</ename>");
		out.print("<job>"+bean.getJob()+"</job>");
		out.print("<mgr>"+bean.getMgr()+"</mgr>");
		out.print("<hiredate>"+bean.getHiredate()+"</hiredate>");
		out.print("<sal>"+bean.getSal()+"</sal>");
		out.print("<comm>"+bean.getComm()+"</comm>");
		out.print("<deptno>"+bean.getDeptno()+"</deptno>");
		out.print("</worker>");

		out.print("</emp>");
		out.close();
		
	}

}
