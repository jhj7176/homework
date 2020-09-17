<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="/resources/template/head.jspf"%>
<%@ include file="/resources/template/header.jspf"%>
<!-- ************************************ ↑ nav-bar **************************************** -->

<div class="row" id="content">
	<div class="col-md-12 page-header">
			<h2>내 서재 <small>책 목록</small>
			</h2>
		</div>
	<div class="col-md-12">
		<table class="table">
			<tr>
				<th>book_id</th>
				<th>title</th>
			</tr>

			<c:forEach items="${books }" var="bean">
				<tr>
					<td><a href="mybooks.bit?book_id=${bean.book_id }">${bean.book_id }</a></td>
					<td>${bean.title }</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</div>


</div>
<!-- container -->
<%@ include file="/resources/template/footer.jspf"%>
</body>
</html>
