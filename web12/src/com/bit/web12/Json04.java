package com.bit.web12;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Json04 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * Dept d = new Dept(); try { List<DeptDto> list = d.getList();
		 * resp.setContentType("application/json;charset=utf-8");
		 * 
		 * System.out.print(list);
		 * 
		 * PrintWriter out = resp.getWriter(); out.print("{\"students\":[");
		 * 
		 * for (int i = 0; i < list.size(); i++) { DeptDto bean = list.get(i);
		 * System.out.println(bean.getDeptno()); if (i != 0) { out.print(","); }
		 * out.print("{"); out.print("\"deptno\":" + bean.getDeptno());
		 * out.print(",\"dname\":\"" + bean.getDname() + "\""); out.print(",\"loc\":\""
		 * + bean.getLoc() + "\""); out.print("}"); } out.print("]}");
		 * 
		 * } catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

		resp.setContentType("application/json;charset=utf-8");

		PrintWriter out = resp.getWriter();

		out.println("{\"students\":[");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from dept";
		try {
			conn = com.bit.model.MyOracle.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			boolean begin = true;
			while (rs.next()) {

				if (rs.isFirst()) {// is.first resultset첫번째 row이면 true
					out.println("{");
					begin = false;// boolean 변수를 만들어서 isFirst처럼 쓸 수 있다.
				} else {
					out.println(",{");
				}
				out.println("\"deptno\":" + rs.getInt("deptno") + ",");
				out.println("\"dname\":\"" + rs.getString("dname") + "\",");
				out.println("\"loc\":\"" + rs.getString("loc") + "\"");
				out.println("}");
			} // while

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // catch
		} // finally

		out.println("]}");

	}

}