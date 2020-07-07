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
	<h1 align="center">Edit Page</h1>
	<jsp:useBean id="bean" class="com.bit.emp.EmpDto"></jsp:useBean><!-- EmpDto타입 bean 선언-->
	<jsp:setProperty property="sabun" name="bean" />
	<!-- bean객체(useBean id)에 필드sabun에게 req.parameter값을 입력 -->
	<!--필드타입에 맞춰서 숫자, 문자 자동으로 parse함  int필드에 문자넣는 건 오류. -->

	<%
		//usebean태그를 이용해서 EmpDto타입 bean래퍼런스 생성함. 
		//detail메서드를 이용해서 bean에 파라미터로 받은 사번의 사원정보 입력함
		bean = EmpSQL.detail(bean.getSabun());
		
		int idx = bean.getSabun();
	%>

	
	
	
	<form method = "post"  action="update.jsp">
	<table width = "50%" align="center">
		<tr>
		<th>Num</th>
		<td><input type = "text" name = "sabun" value="<%=bean.getSabun() %>"></td>
		<tr>	
	
		<tr>
		<th>Name</th>
		<td><input type = "text" name = "name" value="<%=bean.getName() %>"></td>
		<tr>	
	
		<tr>
		<th>Pay</th>
		<td><input type = "text" name = "pay" value="<%=bean.getPay() %>"></td>
		<tr>	
		<tr>
		<td></td>
		<td><input type = "submit" value ="Edit">
		<input type = "reset" value ="Reset"></td>
		<tr>	
	
	
	
	
	
	
	</table>
	</form>
	<br>
	<br>
	<br>


<jsp:include page="../template/footer.jsp"><jsp:param value="../" name="path"/></jsp:include>


</body>
</html>