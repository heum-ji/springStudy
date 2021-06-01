<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>checkPwFrm</title>
</head>
<body>
	<h1>비밀번호 확인</h1>
	<form action="/checkPwMember.do" method="post">
		<input type="hidden" name="memberId" value="${sessionScope.m.memberId }">
		현재 비밀번호 : <input name="memberPw" type="password" placeholder="비밀번호를 입력해주세요." required>
		<input type="submit" value="확인">
	</form>
</body>
</html>