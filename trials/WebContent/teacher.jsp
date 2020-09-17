<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="template/lmshead.jspf" %>
<title>BITCAMP JEJU: LMS강사</title>
<style rel="stylesheet" type="text/css">

</style>
</head>
<body>
<%@ include file="template/lmsheader.jspf" %>
<%@ include file="template/menu.jspf" %>
   <div id="contents">
   <!--*****************lms메뉴******************-->
       <div class="grid2">
        <div id="lmsmenu">
             <p>강사<br><span id="lecname">${login.lecture }</span></p>
            <ul>
                <li class="bigletter">출결관리</li>
                <li>
                    <a href="lmsteacherattendance.bit">출석체크</a>    
                </li>
                <li>
                    <a href="lmsteacherattlist.bit">출석조회</a>    
                </li>
                <li class="bigletter">수강생관리</li>
                <li>
                    <a href="lmsteacherstulist.bit">수강생정보</a>    
                </li>
                <li>
                    <a href="lmsteacherstugrade.bit">성적입력</a>    
                </li>
                <li>
                    <a href="lmsteacherDataroom.bit" class="bigletter">자료실</a>    
                </li>
                <li></li>
            </ul>
        </div>
       </div>
        <!--*****************lms메뉴******************-->
       <div  id="content" class="grid6">
       <!--*************content start****************-->
       <img src="img/capture.PNG">
       <!--*************content end******************-->
<%@ include file="template/footer.jspf" %>
</body>
</html>