<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="/resources/template/head.jspf"%>
<script type="text/javascript">
$(function(){
	console.log('');
});
</script>
<%@ include file="/resources/template/header.jspf"%>
<!-- ************************************ ↑ nav-bar **************************************** -->

<div class="row" id="content">
	<div class="col-md-12">

		<h2>Hello World!</h2>
		<P>The time on the server is ${serverTime}.</P>
		<a class="btn btn-primary" role="btn" href="goSearch.bit">책 검색하기</a> <a
			class="btn btn-default" role="btn" href="mylib.bit">내 책보기</a>
	</div>

</div>


</div>
<!-- container -->
<%@ include file="/resources/template/footer.jspf"%>
</body>
</html>
