<%@page import="com.bit.dept.DeptDto"%>
<%@page import="com.bit.dept.DeptSQL"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bit.emp.EmpDto"%>
<%@page import="com.bit.emp.EmpSQL"%>
<%@page import="com.bit.util.MyOracle"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
a {
	text-decoration: none;
}
</style>
</head>
<body>

	<%
		//use bean
		// page(default) <request <session <application
	%>



	<jsp:include page="../template/header.jsp"><jsp:param
			value="../" name="path" /></jsp:include>
	<jsp:include page="../template/menu.jsp"><jsp:param
			value="../" name="path" /></jsp:include>


	<br>
	<br>
	<h1 align="center">DEPT List</h1>

	<br>



	<table width="45%" align="center">
		<tr>
			<td colspan="4"><a style="color: black;" href="add.jsp"><b>ADD</b></a></td>
		</tr>
		<tr align="center">
			<th>Num</th>
			<th>ID</th>
			<th>Name</th>
			<th>Level</th>
		</tr>

		<%
			DeptSQL dept = new DeptSQL();
			ArrayList<DeptDto> list = dept.list();
			for (DeptDto bean : list) {
		%>
		<tr align="center">
			<td><a style="color: black;"
				href="detail.jsp?num=<%=bean.getNum()%>"><%=bean.getNum()%></a></td>
			<td><a style="color: black;"
				href="detail.jsp?num=<%=bean.getNum()%>"><%=bean.getId()%></a></td>
			<td><%=bean.getName()%></td>
			<td><%=bean.getLev()%></td>
		<tr>


			<%
				}
			%>
		
	</table>
	<br>
	<br>
	<br>

	<jsp:include page="../template/footer.jsp"><jsp:param
			value="../" name="path" /></jsp:include>


</body>
</html>