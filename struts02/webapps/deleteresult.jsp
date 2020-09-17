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

	<h1>DELETE Result page</h1>

	<script type="text/javascript">
		function callback() {
			location.href = 'list.action';
		}
		setTimeout(callback, 2000);
	</script>
</body>
</html>