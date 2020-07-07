<%@page import="java.util.ArrayList"%>
<%@page import="com.bit.emp.EmpDto"%>
<%@page import="com.bit.emp.EmpSQL"%>
<%@page import="com.bit.util.MyOracle"%>
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

<jsp:include page="../template/header.jsp"><jsp:param value="../" name="path"/></jsp:include>
<!-- 헤더파일로 가서 일을 수행하고 다시 돌아와서 코드라인 수행함 
페이지간 이동이 잇으나 클라이언트로 가지않고 list.jsp에서 다 수행한 뒤에 클라로 응답을 보냄. 

[%include file = ""%]은 해당 파일을 list.jsp에 가져와서 컴파일 되기 때문에 액션태그처럼 페이지 간 이동이 없이 list.jsp를 수행하고
클라로 응답을 날린다. 

-->

<jsp:include page="../template/menu.jsp"><jsp:param value="../" name="path"/></jsp:include>



	<br>
	<br>
	<br>
	<h1 align="center">Detail Page</h1>

	<jsp:useBean id="bean" class="com.bit.emp.EmpDto"></jsp:useBean><!-- EmpDto타입 bean 선언-->
	<jsp:setProperty property="sabun" name="bean" />
	<!-- bean객체(useBean id)에 필드sabun에게 req.parameter값을 입력 -->
	<!--필드타입에 맞춰서 숫자, 문자 자동으로 parse함  int필드에 문자넣는 건 오류. -->

	<%
		//usebean태그를 이용해서 EmpDto타입 bean래퍼런스 생성함. 
		//detail메서드를 이용해서 bean에 파라미터로 받은 사번의 사원정보 입력함
		bean = EmpSQL.detail(bean.getSabun());

		int idx = bean.getSabun();
	%>



	<table width="45%" align="center">
		<tr>
			<td colspan="2" align="right"><a style="color: black;"
				href="delete.jsp"><button>Delete</button></a></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<th bgcolor="#6262d7" style="color: white;" width="120">Num</th>
			<td align="center" width="300"><%=bean.getSabun()%></td>
		</tr>
		<tr>
			<th bgcolor="#6262d7" style="color: white;">Name</th>
			<td align="center"><%=bean.getName()%></td>
		</tr>
		<tr>
			<th bgcolor="#6262d7" style="color: white;">HireDate</th>
			<td align="center"><%=bean.getHiredate()%></td>
		</tr>
		<tr>
			<th bgcolor="#6262d7" style="color: white;">Pay</th>
			<td align="center"><%=bean.getPay()%></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>

			<td colspan="2" align="right"><a style="color: black;"
				href="edit.jsp?sabun=<%=idx%>&name=<%=bean.getName()%>>&pay=<%=bean.getPay()%>"><button>Edit</button></a>
				<a style="color: black;" href="list.jsp"><button>Back</button></a></td>
		</tr>

	</table>
	<br>
	<br>
	<br>


<jsp:include page="../template/footer.jsp"><jsp:param value="../" name="path"/></jsp:include>



</body>
</html>