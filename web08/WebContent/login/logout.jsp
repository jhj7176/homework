<%@page import="com.bit.dept.DeptSQL"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="../template/header.jsp"><jsp:param value="../" name="path"/></jsp:include>
<jsp:include page="../template/menu.jsp"><jsp:param value="../" name="path"/></jsp:include>
<jsp:useBean id="login" class ="com.bit.dept.DeptDto" scope = "session"></jsp:useBean>
<jsp:setProperty property="*" name="login"/>


<%
 	DeptSQL dept = new DeptSQL();
	dept.login(login);
	
	login.setResult(false);

	String path = "form.jsp";
	
	
	
	if(login.isResult()){
		
	session.removeAttribute("login");
	}
%>

<jsp:forward page="<%=path%>"></jsp:forward>

</body>
</html>