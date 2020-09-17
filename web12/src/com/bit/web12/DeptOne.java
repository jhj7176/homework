package com.bit.web12;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deptdetail.bit")//webxml의 서블릿 정의한것과 같다.
public class DeptOne extends HttpServlet {

	Logger log = Logger.getGlobal();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int deptno = Integer.parseInt(req.getParameter("idx"));
		log.info("param:"+deptno);
		req.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		try {
			
			PrintWriter out = resp.getWriter();
			
			Dept dao = new Dept();
			DeptDto bean = dao.getOne(deptno);
			
			
			out.print("{\"dept\":[{");
			out.print("\"deptno\":"+bean.getDeptno()+",");
			out.print("\"dname\":\""+bean.getDname()+"\",");
			out.print("\"loc\":\""+bean.getLoc()+"\"");
			out.print("}]}");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	/*
	 * { "dept" :    [{"deptno" : val, "dname" : val, "loc" : val              ]}
	 * 
	 * 
	 * */

			
		
		
	}
}
