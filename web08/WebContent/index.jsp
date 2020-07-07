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
		String path = "./";
	%>

<jsp:include page="template/header.jsp"><jsp:param value="./" name="path"/></jsp:include>
<jsp:include page="template/menu.jsp"><jsp:param value="./" name="path"/></jsp:include>


	<table align="center">
		<tr align="center">
			<td><img width="50%" src="img/tree.png"></td>
		</tr>
	</table>



	<%@ include file="./template/footer.jspf"%>


</body>
</html>