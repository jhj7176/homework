package com.bitjeju.member.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDao {
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement pstmt;
	
	public MemberDao() {
		String driver="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="scott";
		String password="tiger";
		
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//constructor
	
	public MemberDto loginValidation(String id,String password) throws SQLException{
		String sql="select num,id_email,name,dept,lvl,password,phone,lecture from member natural join bitjejudept where id_email=? and password=?";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, password);
		System.out.println(sql);
		rs=pstmt.executeQuery();
		
		MemberDto bean=null;
		if(rs.next()){
			bean=new MemberDto();
			bean.setNum(rs.getInt("num"));
			bean.setId_email(rs.getString("id_email"));
			bean.setName(rs.getString("name"));
			bean.setDept(rs.getString("dept"));
			bean.setLvl(rs.getInt("lvl"));
			bean.setPassword(rs.getString("password"));
			bean.setPhone(rs.getString("phone"));
			bean.setLecture(rs.getString("lecture"));
		} else {
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
			return new MemberDto("fail");
		}
		return bean;
	}
	
}


















