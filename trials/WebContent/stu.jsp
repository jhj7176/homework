<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="template/lmshead.jspf" %>
<title>BITCAMP JEJU: LMS수강생</title>
</head>
<body>
<%@ include file="template/lmsheader.jspf" %>
<%@ include file="template/menu.jspf" %>
   <div id="contents">
   <!--*****************lms메뉴******************-->
       <div class="grid2">
        <div id="lmsmenu">
            <p>수강생<br><span id="lecname">${login.lecture }</span></p>
            <ul>
                <li class="bigletter">
                    <a href="lmsstugrade.bit">성적조회</a>    
                </li>
                <li class="bigletter">
                    <a href="lmsstuattendance.bit">출결조회</a>    
                </li>
                <li class="bigletter">
                    <a href="lmsstulecture.bit">수강정보</a>    
                </li>
                <li class="bigletter">
                    <a href="lmsstudataroom.bit" class="bigletter">자료실</a>    
                </li>
                <li></li>
            </ul>
        </div>
       </div>
        <!--*****************lms메뉴******************-->
       <div  id="content" class="grid6">&nbsp;
       <!--*************content start****************-->
       <img src="img/capture.PNG">
       <!--*************content end******************-->
<%@ include file="template/footer.jspf" %>
</body>
</html>