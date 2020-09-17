package com.bit.emp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bit.model.MyOracle;

public class EmpDao {

	public List<EmpVO> getList() {

		List<EmpVO> list = new ArrayList<EmpVO>();
		String sql = "select * from emp";

		try {
			Connection conn = MyOracle.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				EmpVO bean = new EmpVO();
				bean.setEmpno(rs.getInt("empno"));
				bean.setEname(rs.getString("ename"));
				bean.setJob(rs.getString("job"));
				bean.setHiredate(rs.getDate("hiredate"));
				bean.setMgr(rs.getInt("mgr"));
				bean.setSal(rs.getInt("sal"));
				bean.setComm(rs.getInt("comm"));
				bean.setDeptno(rs.getInt("deptno"));
				list.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}// getlist

	public void insert(int empno, String ename, String job, int deptno) throws SQLException {

		String sql = "insert into emp (empno, ename, job, deptno, sal, hiredate) values (";
		sql += empno + ", upper(' " + ename + " ') ,upper(' " + job + " '), " + deptno + ", 1800, sysdate)";

		System.out.print(sql);
		try {
			Connection conn = MyOracle.getConnection();
			Statement stmt = conn.createStatement();
			stmt.executeQuery(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// insert

	public EmpVO getOne(int empno) {

		String sql = "select * from emp where empno =" + empno;

		EmpVO bean = new EmpVO();

		try {
			Connection conn = MyOracle.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				bean.setEmpno(rs.getInt("empno"));
				bean.setEname(rs.getString("ename"));
				bean.setJob(rs.getString("job"));
				bean.setDeptno(rs.getInt("deptno"));
				bean.setHiredate(rs.getDate("hiredate"));
				bean.setSal(rs.getInt("sal"));
				bean.setComm(rs.getInt("comm"));
				bean.setMgr(rs.getInt("mgr"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;
	}// getOne

	public void deleteOne(String empno) {

		String sql = "delete from emp where empno in (" + empno+")";
		System.out.println(sql);

		try {
			Connection conn = MyOracle.getConnection();
			Statement stmt = conn.createStatement();
			System.out.println("aa");
			stmt.executeQuery(sql);
			System.out.println("bb");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// delete

	public void update(int empno, String ename, String job, int mgr, int sal, String hiredate, int comm, int deptno) {

		String toDate = hiredate.replace("-", "");
		System.out.print(toDate + job);

		String sql = "update emp set ename = '" + ename + "', job = '" + job + "', mgr=" + mgr + ", sal=" + sal
				+ ", comm=" + comm + ", deptno=" + deptno + ", hiredate = to_date('" + toDate
				+ "','YYYYMMDD') where empno = " + empno;
//		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
//		Date hireDate = sdf.parse(hiredate);

		System.out.print(sql);

		try {
			Connection conn = MyOracle.getConnection();
			Statement stmt = conn.createStatement();
			stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// update

}// EmpDao Class