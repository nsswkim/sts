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
	<h1>�� ������</h1>
		<div>
			<table>
					<tr>
				    	<th>���</th>
				    	<td>${bean.sabun }</td>
				    	<th>�̸�</th>
				    	<td>${bean.name }</td>
				    	<th>��¥</th>
				    	<td>${bean.nalja }</td>
				    	<th>�ݾ�</th>
				    	<td>${bean.pay }</td>
				    </tr>
			</table>
				    <button>����</button>	
					<button>����</button>	
		</div>
</body>
</html>