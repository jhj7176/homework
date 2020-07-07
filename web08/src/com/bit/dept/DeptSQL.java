package com.bit.dept;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bit.emp.EmpDto;
import com.bit.util.MyOracle;

public class DeptSQL {

	private static Connection conn;
	private static Statement stmt;
	private static ResultSet rs;

	public ArrayList<DeptDto> list() throws SQLException {
		ArrayList<DeptDto> list = new ArrayList<>();
		String sql = "select * from dept01 order by num";

		conn = com.bit.util.MyOracle.getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		try {
			while (rs.next()) {
				DeptDto bean = new DeptDto();
				bean.setNum(rs.getInt("num"));
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("dname"));
				bean.setLev(rs.getString("lev"));
				bean.setPw(rs.getString("pw"));
				list.add(bean);

			}

		} finally {
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();

		}// finally

		return list;
	}// list

	public void insert(DeptDto bean) {
		String sql = "insert into dept01 values (dept01_seq.nextval,'"
				+ bean.getId() + "' ,'" + bean.getPw() + "' ,'È¸¿ø' ,'"
				+ bean.getName() + "' , sysdate)";

		try {
			conn = MyOracle.getConnection();
			stmt = conn.createStatement();
			stmt.executeQuery(sql);
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
			}
		}// finally

	}// insert

	public void detail(DeptDto bean) {

		// DeptDto bean = new DeptDto();
		String sql = "select * from dept01 where num = " + bean.getNum();

		try {
			conn = MyOracle.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				bean.setNum(rs.getInt("num"));
				bean.setName(rs.getString("dname"));
				bean.setId(rs.getString("id"));
				bean.setPw(rs.getString("pw"));
				bean.setLev(rs.getString("lev"));
				bean.setDtime(rs.getDate("dtime"));

			}// if

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
			}
		}
		// return bean;
	}

	public void login(DeptDto bean) throws SQLException {

		String sql = "select dname, lev from dept01 where id= '"
				+ bean.getId() + "' and";
		sql += " pw='" + bean.getPw() + "'";

		try {

			conn = MyOracle.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				bean.setName(rs.getString("dname"));
				bean.setLev(rs.getString("lev"));
				bean.setResult(true);
			}// if

		} finally {
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}

	}

}// DeptSql
