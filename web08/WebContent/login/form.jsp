<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="../template/header.jsp"><jsp:param
			value="../" name="path" /></jsp:include>


	<jsp:include page="../template/menu.jsp"><jsp:param
			value="../" name="path" /></jsp:include>



	<br>
	<br>
	<br>
	<br>


	<h1 align="center">Login</h1>
	<form action="result.jsp">
		<table border="0" align="center" width="200">

			<tr align="center">
				<td width="200" style="color: white;" bgcolor="#8c8cf5">id</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr align="center">
				<td style="color: white;" bgcolor="#8c8cf5">password</td>
				<td><input type="password" name="pw"></td>
			</tr>
			<tr align="center">
				<td></td>
				<td><input type="submit" value="login"><input
					type="button" name="join" value="join"></td>

			</tr>

		</table>
	</form>


	<br>
	<br>
	<br>
	<br>

	<jsp:include page="../template/footer.jsp"><jsp:param
			value="../" name="path" /></jsp:include>

</body>
</html>