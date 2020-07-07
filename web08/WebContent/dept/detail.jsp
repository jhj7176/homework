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
	<jsp:include page="../template/header.jsp"><jsp:param
			value="../" name="path" /></jsp:include>
	<jsp:include page="../template/menu.jsp"><jsp:param
			value="../" name="path" /></jsp:include>
			
	<jsp:useBean id="bean" class="com.bit.dept.DeptDto"></jsp:useBean><!-- EmpDto타입 bean 선언-->
	<jsp:setProperty property="*" name="bean" />


	<%
		DeptSQL dept = new DeptSQL();
		dept.detail(bean);
	%>

	<br>
	<br>
	<br>
	<h1 align="center"><jsp:getProperty property="num" name="bean" />'s
		Detail Page
	</h1>
	<%
		System.out.println("111111111111111");
	%>

	<table width="45%" align="center">
		<tr>
			<td colspan="2" align="right"><a style="color: black;"
				href="delete.jsp"><button>Delete</button></a></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<%
				System.out.println("222");
			%>
			<th bgcolor="#6262d7" style="color: white;" width="120">ID</th>
			<td align="center" width="300"><jsp:getProperty property="id"
					name="bean" /></td>
		</tr>
		<tr>
			<th bgcolor="#6262d7" style="color: white;">Password</th>
			<td align="center"><jsp:getProperty property="pw" name="bean" /></td>
		</tr>
		<tr>
			<th bgcolor="#6262d7" style="color: white;">Name</th>
			<td align="center"><jsp:getProperty property="name" name="bean" /></td>
		</tr>
		<tr>
			<th bgcolor="#6262d7" style="color: white;">Level</th>
			<td align="center"><jsp:getProperty property="lev" name="bean" /></td>
		</tr>
		<tr>
			<th bgcolor="#6262d7" style="color: white;">Join Date</th>
			<td align="center"><jsp:getProperty property="dtime" name="bean" /></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<%
				System.out.println("33");
			%>
			<td colspan="2" align="right"><a style="color: black;"
				href="edit.jsp"><button>Edit</button></a> <a style="color: black;"
				href="list.jsp"><button>Back</button></a></td>
		</tr>

	</table>
	<br>
	<br>
	<br>


	<jsp:include page="../template/footer.jsp"><jsp:param
			value="../" name="path" /></jsp:include>



</body>
</html>