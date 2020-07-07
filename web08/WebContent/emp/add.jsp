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
	<br>
	<h1 align="center">Add Page</h1>
	
	<form method = "post"  action="insert.jsp">
	<table border="0" width = "30%" align="center">
		<tr align = "center">
		<th width = "120">Num</th>
		<td><input type = "text" name = "sabun" value=""></td>
		<tr>	
	
		<tr align = "center">
		<th>Name</th>
		<td><input type = "text" name = "name" value=""></td>
		<tr>	
	
		<tr align = "center">
		<th>Pay</th>
		<td><input type = "text" name = "pay" value=""></td>
		<tr>	
		<tr>
		<td></td>
		<td align ="center"><input type = "submit" value ="submit"></td>
		<tr>	

	</table>
	</form>
	<br>
	<br>
	<br>


<jsp:include page="../template/footer.jsp"><jsp:param value="../" name="path"/></jsp:include>



</body>
</html>