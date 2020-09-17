package com.bit.emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmpXML extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * 
		 * <emp> <worker> <empno></empno> <ename></ename> .. . .. .. . .. ..
		 * <deptno></deptno> </worker> </emp>
		 */
		EmpDao dao = new EmpDao();

		try {
			req.setCharacterEncoding("utf-8");
			resp.setContentType("application/xml; charset=utf-8");
			PrintWriter out = resp.getWriter();
			List<EmpVO> list = dao.getList();
			out.print("<emp>");

			for (EmpVO bean : list) {
				int empno = bean.getEmpno();
				String ename = bean.getEname();
				String job = bean.getJob();
				int mgr = bean.getMgr();
				Date hiredate = bean.getHiredate();
				int sal = bean.getSal();
				int comm = bean.getComm();
				int deptno = bean.getDeptno();

				out.print("<worker>");
				out.print("<empno>" + empno + "</empno>");
				out.print("<ename>" + ename + "</ename>");
				out.print("<job>" + job + "</job>");
				out.print("<mgr>" + mgr + "</mgr>");
				out.print("<hiredate>" + hiredate + "</hiredate>");
				out.print("<sal>" + sal + "</sal>");
				out.print("<comm>" + comm + "</comm>");
				out.print("<deptno>" + deptno + "</deptno>");
				out.print("</worker>");
			}

			out.print("</emp>");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
