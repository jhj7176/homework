<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>my book contents</h1>
<a href="index.bit">홈으로 돌아가기</a>
	<table>
		<tr>
			<th>book_id</th>
			<th>chapter</th>
			<th>check</th>
		</tr>

		<c:forEach items="${bookChapters }" var="bean">
			<tr>
				<td>${bean.book_id }</td>
				<td>${bean.chapter }</td>
				<td>&nbsp;</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>