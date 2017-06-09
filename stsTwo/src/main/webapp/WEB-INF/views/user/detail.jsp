<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		  <h1>상세페이지<small>${bean.name }님 정보</small></h1>
		</div>
		<ul class="list-group">
		  <li class="list-group-item">
		  	<h2>번호</h2>${bean.num }
		  </li>
		  <li class="list-group-item">
		  	<h2>사번</h2>${bean.sabun }
		  </li>
		  <li class="list-group-item">
		  	<h2>이름</h2>${bean.name }
		  </li>
		  <li class="list-group-item">
		  	<h2>날짜</h2>${bean.nalja }
		  </li>
		</ul>
		<div class="btn-group btn-group-lg  btn-group-justified" role="group" aria-label="...">
			<a class="btn btn-primary" href="edit?idx=${bean.num }" role="button">수정</a>
			<a class="btn btn-danger" href="del?idx=${bean.num }" role="button">삭제</a>
		</div>
		
	</div>
	<jsp:include page="/template/footer.jsp"></jsp:include>
</body>
</html>