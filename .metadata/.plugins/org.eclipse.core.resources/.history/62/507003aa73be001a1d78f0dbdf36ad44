
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../template/header.jspf"%>
	<%
	System.out.println("check");
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	System.out.println("check222"+title+writer+content);

	try {
		String back = request.getParameter("back");
		if (back.equals("글목록")) {
			response.sendRedirect("list.jsp");
			return;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}

	String sql = "insert into board (num, title, writer, wtime, content, ref, no, lev) values (";
	sql += "board_seq.nextval, '" + title + "', '" + writer + "', sysdate, '" + content + "', board_seq.currval,0,0)";

	try {
		conn = DriverManager.getConnection(url, info);
		stmt = conn.createStatement();
		stmt.executeQuery(sql);
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		if (stmt != null)
			stmt.close();
		if (conn != null)
			conn.close();
		response.sendRedirect("list.jsp");
	}
	%>




</body>
</html>