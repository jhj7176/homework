<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/bitgrid.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="template/head.jspf"%>
<script src="jquery/jquery-ui.min.js"></script>
<link rel="stylesheet" href="jquery/jquery-ui-1.12.1/jquery-ui.css"/>
<title>Insert title here</title>
<script type="text/javascript">
	$(document).ready(function() {
		$('#progressbar').progressbar({value : 20});
		$('#progressbar').find(".ui-progressbar-value").css({"background":"#FFCC66"});
		$('#progresstext').html('HTML Test');
	});
</script>

<style type="text/css">
#bardivs {
	width: 300px; /* 100% */
	position: relative;
}
#progresstext {
	position: absolute;
 	top: 0;
	left: 0;
	width: 100%;
	padding-top: 5px;
	text-align: center;
}
</style>
</head>
<body>
	<%@ include file="template/header.jspf"%>
	<%@ include file="template/menu.jspf"%>
	<div id="carousel" class="gird12">
		<img src="img/forc.jpg">
	</div>
	<!--carousel-->
	<div id="contents">
		<div class="grid2">&nbsp;</div>
		<div id="content" class="grid6">
			&nbsp;
			<!--*************content start****************-->

			<div id="bardivs">
				<div id="progressbar"></div>
				<div id="progresstext"></div>
			</div>


			<!--*************content end******************-->
			<%@ include file="template/footer.jspf"%>
</body>
</html>
<!-- 
-1번라인의 charset, pageEncoding 7번라인의 charset모두 utf-8로 맞춰주세요.
-3번의 doctype도 다지우고 위처럼 html만 남겨주세요.
-content내부에 content와 sidebar로 나눔 ->content에 작업하면됩니다.
-sidebar에서 사용하고 있는 id: #signin #emailid #pw #login #createccount #campus #campusinfo #classinfo #open
-footer에서 사용하고있는 id: #footercon .gotolms
위의 아이디들은 작업시 사용하지 마세요 이름바꾸고 싶으면 저와 의논바람
 -->