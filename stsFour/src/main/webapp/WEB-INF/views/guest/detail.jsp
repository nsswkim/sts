<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>상세 페이지</h1>
		<div>
			<table>
					<tr>
				    	<th>사번</th>
				    	<td>${bean.sabun }</td>
				    	<th>이름</th>
				    	<td>${bean.name }</td>
				    	<th>날짜</th>
				    	<td>${bean.nalja }</td>
				    	<th>금액</th>
				    	<td>${bean.pay }</td>
				    </tr>
			</table>
				    <button>수정</button>	
					<button>삭제</button>	
		</div>
</body>
</html>