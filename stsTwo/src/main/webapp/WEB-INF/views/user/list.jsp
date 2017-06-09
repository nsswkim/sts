<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/template/header.jsp"></jsp:include>
	<jsp:include page="/template/menu.jsp">
		<jsp:param value="2" name="active"/>
	</jsp:include>
	<div class="panel-body">
		<div class="page-header">
		  <h1>리스트페이지<small>GUEST_USER 테이블</small></h1>
		</div>
		<table class="table table-condensed">
			<tr>
				<th>no</th>
				<th>사번</th>
				<th>이름</th>
				<th>날짜</th>
			</tr>
			<c:forEach items="${alist }" var="bean">
				<tr>
					<td>${bean.num }</td>
					<td>${bean.sabun }</td>
					<td>${bean.name }</td>
					<td>${bean.nalja }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<jsp:include page="/template/footer.jsp"></jsp:include>
</body>
</html>