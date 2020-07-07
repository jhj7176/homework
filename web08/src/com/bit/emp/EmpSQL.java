package com.bit.emp;

import java.util.ArrayList;
import java.sql.*;

import com.bit.util.MyOracle;

public class EmpSQL {

	private static Connection conn;
	private static Statement stmt;
	private static ResultSet rs;

	public static ArrayList<EmpDto> list() {

		ArrayList<EmpDto> list = new ArrayList<>();
		String sql = "select * from emp02 order by sabun";

		try {
			conn = com.bit.util.MyOracle.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				EmpDto bean = new EmpDto();
				bean.setSabun(rs.getInt("sabun"));
				bean.setName(rs.getString("name"));
				bean.setHiredate(rs.getDate("hiredate"));
				bean.setPay(rs.getInt("pay"));
				list.add(bean);
			}// while

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

		return list;

	}// list

	public static void insert(int sabun, String name, int pay) {
		String sql = "insert into emp02 values (" + sabun + ",'" + name
				+ "',sysdate," + pay + ")";

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

	public static void update(int sabun, String name, int pay) {

		String sql = "update emp02 set name = '" + name + "', pay = " + pay
				+ "where sabun =" + sabun;

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

	}// update

	public static EmpDto detail(int sabun) {
		EmpDto bean = new EmpDto();
		String sql = "select * from emp02 where sabun = " + sabun;

		try {
			conn = MyOracle.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				bean.setSabun(rs.getInt("sabun"));
				bean.setName(rs.getString("name"));
				bean.setHiredate(rs.getDate("hiredate"));
				bean.setPay(rs.getInt("pay"));
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
		return bean;
	}

	public static void delete() {
	}

}// EmpSQL
