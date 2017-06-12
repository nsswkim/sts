
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="/day03/resources/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="/day03/resources//css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="/day03/resources/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
	
<script type="text/javascript">

	var param=${bean.sabun};
	$(document).ready(function() {
		$("#update").hide();
		
		$("#detail button").eq(0).click(function() {
			$("#update").show();
			$("#detail").hide();
			$(".page-header small").text("수정페이지");
		}).next().click(function() {
			if(window.confirm("삭제하시겠습니까?")){
				$.ajax({
					header :{"X-HTTP-Method-Override":"DELETE" },					
					method:'delete',
					contentType:'application/jso',
					dataType:'text',
					success:function(){
						window.location.replace=("/day03/list");
					}					
				});
			}
		});		
	});
</script>

</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/day03/">
					<p>한빛교육센터
					<p>
				</a>
			</div>
			<a class="navbar-text">MENU1</a> <a class="navbar-text">MENU2</a> <a
				class="navbar-text" href="/day03/list">GUEST</a>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="/day03/">Home</a></li>
				<li><a href="/day03/list">list</a></li>
				<li><a href="/day03/guest">add</a></li>
			</ol>
		</div>

		<div class="row">
			<div class="col-md-4">

				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">메뉴</h3>
					</div>
					<div class="panel-body">
						<ul class="nav nav-pills nav-stacked">
							<li class="active"><a href="/day03/list">목록</a></li>
							<li><a href="/day03/guest">글쓰기</a></li>
						</ul>
					</div>
					<div class="panel-footer"></div>
				</div>


			</div>
			<div class="col-md-8">
				<div class="page-header">
					<h1>
						${bean.name }의 정보 <small>상세페이지</small>
					</h1>
				</div>
				<div id="detail" class="panel panel-default">
				  <div class="panel-heading"></div>
				  <div class="panel-body">
				    <dl class="dl-horizontal">
				    	<dt>사번</dt>
				    	<dd>${bean.sabun }</dd>
				    	<dt>이름</dt>
				    	<dd>${bean.name }</dd>
				    	<dt>날짜</dt>
				    	<dd>${bean.nalja }</dd>
				    	<dt>금액</dt>
				    	<dd>${bean.pay }</dd>
				    </dl>
				    <button>수정</button>	
					<button>삭제</button>
				  </div>
				</div>
		    	<div id="update">
		    		<form class="form-horizontal" method="post">
		    		<!-- web.xml HiddenHttpMethodFilter클래스 filter 등록 -->
		    		<input type="hidden" name="_method" value="put" />
					  <div class="form-group">
					    <label for="sabun" class="col-sm-2 control-label">사번</label>
					    <div class="col-sm-10">
					      <input type="text" value="${bean.sabun }" name="sabun" class="form-control" id="sabun" placeholder="sabun" readonly="readonly">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="name" class="col-sm-2 control-label">이름</label>
					    <div class="col-sm-10">
					      <input type="text" value="${bean.name }" name="name" class="form-control" id="name" placeholder="name">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="pay" class="col-sm-2 control-label">금액</label>
					    <div class="col-sm-10">
					      <input type="text" value="${bean.pay }" name="pay" class="form-control" id="pay" placeholder="pay">
					    </div>
					  </div>
					  
					  <div class="form-group">
					    <div class="col-sm-offset-2 col-sm-10">
					      <button type="submit" class="btn btn-default">수 정</button>
					     </div>
					  </div>
					</form>
		    	</div>
					
			</div>
		</div>
	</div>
</body>
</html>