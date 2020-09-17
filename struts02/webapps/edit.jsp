<%@page import="com.bit.dept.model.entity.DeptVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EDIT page</h1>
	<form action="update.action" method="post">
		<div>
			<label for="deptno">deptno</label> 
			<input type="text" name="deptno" id="deptno" value="${bean.deptno }" readonly="readonly"/>
		</div>
		<div>
			<label for="dname">dname</label> 
			<input type="text" name="dname" id="dname" value="${bean.dname }"/>
		</div>
		<div>
			<label for="loc">loc</label> 
			<input type="text" name="loc" id="loc" value="${bean.loc }"/>
		</div>
		<div>
			<button type="submit">edit</button>
		</div>
	</form>
</body>
</html>