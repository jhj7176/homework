package com.bit.emp;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmpAdd extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		// empno=a&ename=b&job=c&deptno=20
		String[] params = new String[4];
		String[] paramName = { "empno", "ename", "job", "deptno" };
		for (int i = 0; i < paramName.length; i++) {
			params[i] = req.getParameter(paramName[i]);
		}
		System.out.println(Arrays.toString(params));
		
		EmpDao dao = new EmpDao();
		try {
			dao.insert(Integer.parseInt(params[0]), params[1], params[2], Integer.parseInt(params[3]));
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
