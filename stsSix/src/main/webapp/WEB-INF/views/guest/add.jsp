<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>입력페이지</h1>
<form method="post">
	<label for="sabun">sabun</label>
	<input type="text" name="sabun" id="sabun"  value="${bean.sabun }"/>${err.sabun }<br/>
	<label for="name">name</label>
	<input type="text" name="name" id="name"  value="${bean.name }"/>${err.name }<br/>
	<label for="pay">pay</label>
	<input type="text" name="pay" id="pay" value="${bean.pay }"/>${err.pay }<br/>
	<button>입력</button>
</form>
</body>
</html>