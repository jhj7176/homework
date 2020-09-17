package com.bitjeju.stu.lecture.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LectureDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public LectureDao() {
		String driver="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="scott";
		String password="tiger";
		
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public LectureDto selectInfo(int num) throws SQLException{
		LectureDto bean=null;
		String sql="select lecture_name,start_day,end_day,lecture_room,name from member full outer join lectures "
				+ "on member.num=lectures.num where lecture_name = (select lecture from member where num = ?)";
		System.out.println(sql);
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, num);
		rs=pstmt.executeQuery();
		try{
			while(rs.next()){
				bean=new LectureDto();
				bean.setLecture_name(rs.getString("Lecture_name"));
				bean.setStart_day(rs.getDate("start_day"));
				bean.setEnd_day(rs.getDate("end_day"));
				bean.setName(rs.getString("name"));
				bean.setLecture_room(rs.getInt("lecture_room"));
			}
		}finally{
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
		return bean;
	}
}
