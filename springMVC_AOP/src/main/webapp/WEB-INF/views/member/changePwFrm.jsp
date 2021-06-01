<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>changePwFrm</title>
</head>
<body>
	<h1>비밀번호 수정</h1>
	<form action="/changePw.do" method="post">
		새로운 비밀번호 : <input name="memberPw" type="password" placeholder="비밀번호를 입력해주세요."><br>
		비밀번호 확인 : <input type="password">
		<input type="submit" value="수정">
	</form>
</body>
</html>