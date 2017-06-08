<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EX02 page - ${msg }</h1>
	<form action="ex10" method="get">
	<label for="id"></label>
	<input type="text" name="id" id="id">
	<label for="pw"></label>
	<input type="text" name="pw" id="pw">
	<button>전달</button>
	</form>
</body>
</html>