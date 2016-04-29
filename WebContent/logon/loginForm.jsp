<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
<script>
$(function(){
	$("#btn_login_submit").click(function(){
		if($("#id").val()=="" || $("#passwd").val()=="") {
			if($("#id").val()=="") {
				alert("아이디를 입력해 주세요");
				$("#id").focus();
			} else {
				alert("비밀번호를 입력해 주세요");
				$("#passwd").focus();
			}
		} else {
			$("#loginForm").submit();
		}
	});
	$("#btn_join").click(function(){
		$(location).attr("href","/Reviwer/logon/inputForm.do");
	});
	$("#btn_find").click(function(){
		$(location).attr("href","/Reviwer/idpwSearch/idpwSearchNew.do");
	});
});

</script>
<style>

</style>
<title>로그인</title>
</head>
<body>
<c:if test="${login_status!=2}">
	<%response.sendRedirect("/Reviwer/main/mainForm.do"); %>
</c:if>
<c:if test="${message!=null}">
	<script>alert("아이디 또는 패스워드가 일치하지 않습니다");</script>
</c:if>
<div id="logon">
	<form method="post" action="/Reviwer/logon/loginPro.do" name="loginFrom" id="loginForm">
		<div id="loginForm">
			<div id="login_logo"><img src="../image/reviwer_gray.png" ></div>
			<div id="div_id" class="size_long"><input type="text" class="text_login" id="id" name="id" placeholder="아이디" ></div>
			<div id="div_passwd" class="size_long"><input type="password" class="text_login" id="passwd" name="passwd" placeholder="비밀번호"></div>	
			<div id="btn_login_submit" class="btn_long"><a href="#" >로 그 인</a></div>
		</div>
	</form>
	<div id="join_find">
		<div id="btn_join" class="btn_long"><a href="#" >회 원 가 입</a></div>
		<div id="btn_find" class="btn_long"><a href="#" >아이디/비밀번호 찾기</a></div>
	</div>
</div>
</body>
</html>