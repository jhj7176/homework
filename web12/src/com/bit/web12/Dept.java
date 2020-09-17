package com.bit.web12;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.bit.model.MyOracle;

public class Dept {

	
	
	public List<DeptDto> getList() {

		String sql = "select * from dept";
		List<DeptDto> list = new ArrayList<DeptDto>();

		try {
			Connection conn = MyOracle.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				DeptDto bean = new DeptDto();
				bean.setDeptno(rs.getInt("deptno"));
				bean.setDname(rs.getString("dname"));
				bean.setLoc(rs.getNString("loc"));
				list.add(bean);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public DeptDto getOne(int deptno) {
		DeptDto bean = new DeptDto();
		String sql = "select * from dept where deptno="+ deptno;
		
		try {
			Connection conn = MyOracle.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				bean.setDeptno(rs.getInt("deptno"));
				bean.setDname(rs.getString("dname"));
				bean.setLoc(rs.getString("loc"));
			}//while
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;
	}//deptno
	

}
