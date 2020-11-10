<%@ page session="true" %> <!-- 세선을 체크하기 위해서는 상단에 page session을 true로 설정한다. -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" 		uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="layoutTag" 	tagdir="/WEB-INF/tags" %>

<layoutTag:layout>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원탈퇴</title>
</head>
<body>
	<div class="container">
	<form class="form-horizontal" method="post" action="/member/memberDelete">
		<div class="form-group">
			<div class="col-sm-2"></div>
			<div class="col-sm-6">
				<h2 align="left">회원탈퇴</h2>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">아이디</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="userid" name="userid" value="${member.userid}" readonly="readonly"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">비밀번호</label>
			<div class="col-sm-2">
				<input type="password" class="form-control" id="passwd" name="passwd"
					value="${member.passwd}" maxlength="16" placeholder="비밀번호를 입력하세요."/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">이  름</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="name" name="name"
					value="${member.name}"maxlength="16" readonly="readonly"/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-4">
				<button class="btn btn-success" type="submit" id="submit">회원정보탈퇴</button>
				<button class="btn btn-danger cancel" type="reset">취소</button>
			</div>
		</div>
	<!-- 회원탈퇴버튼을 눌렀는데 비밀번호가 맞지 않으면 메시지를 보여준다. -->
	<c:if test="${msg== false}">
	<div class="form-group">
		<div class="col-sm-8">
			<h3><span class="label label-danger">로그인에 실패하였습니다.비밀번호를 다시 입력하세요.</span></h3>
		</div>
	</div>
</c:if>
</form>
</div>

<script>
$(document).ready(function(){
	$(".cancel").on("click", function() {
		location.href = "/member/login";
	});
	$("#submit").on("click",function(){
		if($("#userid").val() == "") {
				alert("아이디를 입력하십시오.");
				$("#userid").focus();
				return false;
			}	
		if($("#passwd").val() == "") {
			alert("비밀번호를 입력하십시오.");
			$("#passwd").focus();
			return false;
			}
		
		});
	
});


</script>
</body>
</html>
</layoutTag:layout>