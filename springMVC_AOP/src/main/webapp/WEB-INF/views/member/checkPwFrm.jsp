<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>checkPwFrm</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.3.1.js"></script>
<style>
form {
	display: none;
	margin-top: 100px;
}
</style>
</head>
<body>
	<h1>비밀번호 확인</h1>
	
	 현재 비밀번호 : <input name="pwd" type="password" placeholder="비밀번호를 입력해주세요." required>
	<input type="button" value="확인" onclick="checkPw();">
	
	<form action="/changePw.do" method="post">
		<input type="hidden" name="memberId" value="${sessionScope.m.memberId }">
		새 비밀번호 입력 : <input type="password" name="memberPw">
		<input type="submit" value="비밀번호 변경">
	</form>
	
	<script>
		function checkPw() {
			var memberPw = $("[name=pwd]").val();
			var memberId = $("[name=memberId]").val();
			
			$.ajax({
				url : "/checkPw.do",
				data : { memberId : memberId, memberPw : memberPw},
				type : "post",
				success : function(data) {
					if(data == 1) { // 비밀번호 체크된 경우
						$("form").show();
					} else {	
						alert("비밀번호를 확인해주세요."); // 비밀번호 틀린 경우
					}
				}
			});
		}
	</script>
</body>
</html>