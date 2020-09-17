<%@page import="com.bit.dept.model.entity.DeptVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>DETAIL page</h1>

	<%
		DeptVo bean = (DeptVo) request.getAttribute("bean");
	%>
	<table>
		<tr>
			<th>deptno</th>
			<td><%=bean.getDeptno()%></td>
		</tr>
		<tr>
			<th>dname</th>
			<td><%=bean.getDname()%></td>
		</tr>
		<tr>
			<th>loc</th>
			<td><%=bean.getLoc()%></td>
		</tr>
	</table>

	<a href="edit.action?deptno=<%=bean.getDeptno()%>">edit</a>
	<a href="delete.action?deptno=<%=bean.getDeptno()%>">delete</a>
	<a href="list.action">LIST</a>
</body>
</html>