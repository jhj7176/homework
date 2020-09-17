package com.bit.emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Emp extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("application/json;charset=utf-8");

		EmpDao dao = new EmpDao();
		List<EmpVO> list = dao.getList();
		PrintWriter out = resp.getWriter();
		/*
		 * json { key :[ {}, {} ,{} ] }
		 * 
		 * 
		 */
		out.print("{\"emp\":[");

		for (EmpVO bean : list) {

			int empno = bean.getEmpno();
			String ename = bean.getEname();
			String job = bean.getJob();
			Date hiredate = bean.getHiredate();
			int mgr = bean.getMgr();
			int sal = bean.getSal();
			int comm = bean.getComm();
			int deptno = bean.getDeptno();

			if (list.indexOf(bean) != 0) {
				out.print(",");
			}
			out.print("{\"empno\" : " + empno);
			out.print(",\"ename\" : \"" + ename + "\"");
			out.print(",\"job\" : \"" + job + "\"");
			out.print(",\"hiredate\" : \"" + hiredate + "\"");
			out.print(",\"mgr\" : " + mgr);
			out.print(",\"sal\" : " + sal);
			out.print(",\"comm\" : " + comm);
			out.print(",\"deptno\" : " + deptno + "}");
		}
		out.print("]}");
		out.close();
	}
}
