package com.bit.boardvo;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.SimpleFormatter;

import com.bit.model.MyOracle;

import java.sql.*;
import java.text.SimpleDateFormat;

public class BoardDao {
	SimpleDateFormat sdf = new SimpleDateFormat("YY-MM-dd");
	SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");

	public BoardDao() {
		// TODO Auto-generated constructor stub
	}

	public List<BoardVO> getList(int pageNum, String key, String word) {
		List<BoardVO> list = new ArrayList<BoardVO>();
//		 pageNum = 1;
//		if (request.getParameter("pageNum") != null) {
//			pageNum = Integer.parseInt(request.getParameter("pageNum"));
//		}

		int startNum = 1 + (pageNum - 1) * 20;
		int endNum = 20 + (pageNum - 1) * 20;// 페이지당 게시글 수
		// 게시글 컬럼명 제목 or 글쓴이
		// 게시글 검색어
//		if (key == null)
//			key = "title";
//		if (word == null)
//			word = "";
		if (key == null || key.trim() == "")
			key = "title";
		if (word == null || word.trim() == "")
			word = "";
		String sql = "select * from (select num,title, writer, wtime, ref, no, lev, rownum as rwn from ";
		sql += "(select * from board where " + key + " like '%" + word + "%' order by ref desc)) ";
		sql += "where rwn between " + startNum + " and " + endNum + " order by ref desc, no";
		System.out.println(sql);
		try {
			Connection conn = MyOracle.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				BoardVO bean = new BoardVO();
				bean.setNum(rs.getInt("num"));
				bean.setTitle(rs.getString("title"));
				bean.setWriter(rs.getString("writer"));
				// bean.setWtime(rs.getString("wtime"));
				bean.setRef(rs.getInt("ref"));
				bean.setNo(rs.getInt("no"));
				bean.setLev(rs.getInt("lev"));
				java.util.Date now = new java.util.Date();
				String tmp = sdf.format(now);
				System.out.println(tmp);
				System.out.println("시간111="+sdf.format(rs.getDate("wtime")));
				System.out.println(sdf.format(rs.getDate("wtime")).equals(tmp));
				
				
				if (sdf.format(rs.getDate("wtime")).equals(tmp)) {
					bean.setWtime(sdf2.format(rs.getTimestamp("wtime")));
					System.out.println("시간222="+sdf2.format(rs.getDate("wtime")));
				} else {
					bean.setWtime(sdf.format(rs.getDate("wtime")));
				}//else

				list.add(bean);
			}//while
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}// getList
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void reAddPost(int num, String title,String writer, String content) throws SQLException {
		//num : 원글 번호를 받아온다.
		//답글 번호는 board_seq로 부여.
		String sql = "select ref, no, lev from board where num=?";
		Connection conn = MyOracle.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, num);//원글의 글번호. 
		ResultSet rs = pstmt.executeQuery();
		int ref=0;
		int no=0;
		int lev=0;
		while(rs.next()) {
			ref = rs.getInt("ref");
			no=rs.getInt("no");
			lev=rs.getInt("lev");//원글의 ref와 no와 lev을 받아옴
		}//while
		if(pstmt!=null)pstmt.close();
		////////////////////////////////////////////원글의 순서정렬정보 받음
		
		//답글의 삽입 values 정보 
		String sql2="insert into board values (board_seq.nextval,"+title+",";
		sql2+=writer+",sysdate,"+content+","+ref+",("+no+"+1),("+lev+"+1))";
		//  num,title, writer, wtime, ref, no, lev 
		//stmt = conn.createStatement();
		Statement stmt = conn.createStatement();
		rs = stmt.executeQuery(sql2);
		
		if(stmt!=null) stmt.close();
		if(conn!=null) conn.close();
		
		/*
 NUM                                       NOT NULL NUMBER
 TITLE                                     NOT NULL VARCHAR2(200)
 WRITER                                             VARCHAR2(40)
 WTIME                                              DATE
 CONTENT                                            VARCHAR2(3000)
 REF                                                NUMBER
 NO                                                 NUMBER
 LEV                                                NUMBER
		 * 	*/
	}//reAddPost
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void addPost(String title, String writer, String content) throws SQLException {
		String sql = "insert into board values (board_seq.nextval, ?,?,sysdate,?,";
		sql += "board_seq.currval,0,0)";
		System.out.println(sql);
		// String content = content2.replace("<br/>", "\r\n").replace("<br>", "\r\n");

		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			conn = MyOracle.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, writer);
			pstmt.setString(3, content);
			pstmt.executeQuery();
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} // finally
	}// addPost

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void editPost(int num, String title, String content) throws SQLException {
		String sql = "update board set title=?,content=?,wtime=sysdate where num=?";
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			conn = MyOracle.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, num);
			pstmt.executeQuery();
		} finally {
			// TODO Auto-generated catch block
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} // finally

	}// editPost

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void deletePost(int num) throws SQLException {
		String sql = "delete from board where num = ?";
		System.out.println(sql);

		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			conn = MyOracle.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeQuery();
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} // finally
	}// deletePost

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public int getCardinality(String key, String word) {
		int cardinality = 0;
		if (key == null || key.trim() == "")
			key = "title";
		if (word == null || word.trim() == "")
			word = "";
		String sql = "select count(*) from board where " + key + " like '%" + word + "%'";

		try {
			Connection conn = MyOracle.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				cardinality = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cardinality;
	}// getCardinality

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public MemberVO login(String id, String password) {
		String sql="select * from member where id=? and password=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO bean = new MemberVO();
		
		try {
			conn = MyOracle.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean.setLvl(rs.getInt("lvl"));
				bean.setId(rs.getString("id"));
				bean.setPassword(rs.getString("password"));
				System.out.println(rs.getInt("lvl"));
			}//if
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return bean;
	}
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public BoardVO getContent(int idx) {
		BoardVO bean = new BoardVO();

		String sql = "select * from board where num = " + idx;

		java.util.Date now = new java.util.Date();
		String tmp = sdf.format(now);
		String wtime = null;
		Date wtime2 = null;
		try {
			Connection conn = MyOracle.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				bean.setContent(rs.getString("content"));
				bean.setNum(rs.getInt("num"));
				bean.setWriter(rs.getString("writer"));
				// bean.setWtime(rs.getDate("wtime"));
				bean.setTitle(rs.getString("title"));

				SimpleDateFormat sdfTimestamp = new SimpleDateFormat("YYYY-MM-dd HH:mm");
				if (sdf.format(rs.getDate("wtime")).equals(tmp)) {
					bean.setWtime(sdfTimestamp.format(rs.getTimestamp("wtime")));
					System.out.println("시간222="+sdf2.format(rs.getDate("wtime")));
				} else {
					bean.setWtime(sdf.format(rs.getDate("wtime")));
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bean;
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}// classEnd
