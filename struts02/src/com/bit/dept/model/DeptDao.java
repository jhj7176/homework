package com.bit.dept.model;

import java.sql.*;
import java.util.ArrayList;

import com.bit.dept.model.entity.DeptVo;

public class DeptDao {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public DeptDao() {
		String driver = "org.mariadb.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/xe";
		String user = "scott";
		String password = "tiger";
//https://mariadb.com/kb/en/about-mariadb-connector-j/

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("connected");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// Constructor

	public ArrayList<DeptVo> selectAll() {
		ArrayList<DeptVo> list = new ArrayList<>();
		String sql = "select * from dept";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new DeptVo(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc")));
			} // while

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} // finally

		return list;
	}// selectAll

	public void insertOne(String dname, String loc) {
		// TODO Auto-generated method stub
		String sql = "insert into dept (dname,loc) values (?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dname);
			pstmt.setString(2, loc);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} // finally

	}// insertOne

	public DeptVo selectOne(int deptno) {
		// TODO Auto-generated method stub

		DeptVo bean = new DeptVo();
		String sql = "select * from dept where deptno = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bean.setDeptno(rs.getInt("deptno"));
				bean.setDname(rs.getString("dname"));
				bean.setLoc(rs.getString("loc"));
			} // if

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // finally
		return bean;
	}// selectOne

	public void updateOne(int deptno, String dname, String loc) {
		// TODO Auto-generated method stub
		String sql = "update dept set dname=?,loc=? where deptno=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dname);
			pstmt.setString(2, loc);
			pstmt.setInt(3, deptno);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // finally
	}// updateOne

	public void deleteOne(int deptno) {

		String sql = "delete from dept where deptno=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // finally
	}// deleteOne

}// DaoclassEnd
