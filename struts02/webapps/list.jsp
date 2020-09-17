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

	<h1>LIST page</h1>

	<table>
		<tr>
			<th>deptno</th>
			<th>dname</th>
			<th>loc</th>
		</tr>
		<%
			ArrayList<DeptVo> list = (ArrayList<DeptVo>) request.getAttribute("list");
		for (int i = 0; i < list.size(); i++) {
			DeptVo bean = list.get(i);
		%>
		<tr>
			<td><a href="detail.action?deptno=<%=bean.getDeptno()%>"><%=bean.getDeptno()%></a></td>
			<td><a href="detail.action?deptno=<%=bean.getDeptno()%>"><%=bean.getDname()%></a></td>
			<td><a href="detail.action?deptno=<%=bean.getDeptno()%>"><%=bean.getLoc()%></a></td>
		</tr>
		<%
			} //for
		%>
	</table>

	<a href="add.action">ADD</a>
</body>
</html>