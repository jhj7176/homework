<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ADD page</h1>
	<form action="insert.action" method="post">
		<div>
			<label for="dname">dname</label> 
			<input type="text" name="dname" id="dname" />
		</div>
		<div>
			<label for="loc">loc</label> 
			<input type="text" name="loc" id="loc" />
		</div>
		<div>
			<button type="submit">add</button>
		</div>
	</form>
</body>
</html>