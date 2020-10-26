<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시글 상세 정보</title>
	<%@ include file="../include/header.jsp" %>
</head>
<body>
	<%@ include file="../include/topmenu.jsp" %>
<div class="container">
	<form class="form-horizontal" method="post">
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-6">
				<h2 align="center">게시글 상세 정보</h2>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">제 목</label>
			<div class="col-sm-6">
			<input class="form-control" type="text" name="title" value="${boardDTO.b_title}"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">작 성 자</label>
			<div class="col-sm-2">
				<input class="form-control" type="text" name="writer" value="${boardDTO.b_writer}" readonly="readonly"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">작 성 일 자</label>
			<div class="col-sm-4">
				<input class="form-control" type="text" name="regDate" value="<fmt:formatDate value='${boardDTO.b_date}' pattern='yyyy-MM-dd'/>" readonly="readonly"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">내 용</label>
			<div class="col-sm-6">
				<textarea rows="10" cols="100" name="content">${boardDTO.b_detail}</textarea>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-3">
			
				<button type="button" class="btn btn-info" onclick="location.href='/board/update?b_no=${boardDTO.b_no}'">수정</button>&nbsp;&nbsp;&nbsp;
				<button type="button" class="btn btn-danger" onclick="location.href='/board/delete?b_no=${boardDTO.b_no}'">삭제</button>
			</div>
		</div>
	</form>
</div>
	
	
	<%@ include file="../include/footer.jsp" %>
</body>
</html>