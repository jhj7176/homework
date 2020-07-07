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

<jsp:include page="../template/header.jsp"><jsp:param value="../" name="path"/></jsp:include>
<jsp:include page="../template/menu.jsp"><jsp:param value="../" name="path"/></jsp:include>


	<br>
	<br>
	<h1 align="center">EMP List</h1>
	<br>
	
	
	
	<table width = "45%" align="center">
	<tr><td colspan="4"><a style = "color:black;" href="add.jsp"><b>ADD</b></a></td></tr>
		<tr align="center">
			<th>Num</th>
			<th>Name</th>
			<th>HireDate</th>
			<th>Pay</th>
		</tr>

		<%
			ArrayList<EmpDto> list = EmpSQL.list();
			for (int i = 0; i < list.size(); i++) {
				EmpDto bean = list.get(i);
		%>
		<tr align ="center">
			<td><%=bean.getSabun()%></td>
			<td><a style="color:black;" href="detail.jsp?sabun=<%=bean.getSabun()%>"><%=bean.getName()%></a></td>
			<td><%=bean.getHiredate()%></td>
			<td><%=bean.getPay()%></td>
		</tr>
		<%
			}
		%>


	</table>
	<br>
	<br>
	<br>


<jsp:include page="../template/footer.jsp"><jsp:param value="../" name="path"/></jsp:include>


</body>
</html>