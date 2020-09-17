package com.bit.emp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmpUpdate extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String param1 = req.getParameter("empno");
		String param2 = req.getParameter("ename");
		String param3 = req.getParameter("job");
		String param4 = req.getParameter("sal");
		String param5 = req.getParameter("comm");
		String param6 = req.getParameter("deptno");
		String param7 = req.getParameter("mgr");
		String param8 = req.getParameter("hiredate");
		//to_date('20200101','YYYYMMDD')
		System.out.print("param8 = "+param8);
		
		int empno = Integer.parseInt(param1);
		String ename = param2;
		String job = param3;
		int sal = Integer.parseInt(param4);
		int comm = Integer.parseInt(param5);
		int deptno = Integer.parseInt(param6);
		int mgr = Integer.parseInt(param7);
		String hiredate = param8;
		
		
		try {
			com.bit.emp.EmpDao dao = new com.bit.emp.EmpDao();
			dao.update(empno, ename, job, mgr, sal, hiredate, comm, deptno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}//doPOst

}
