<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
	<h1>응애!</h1>
	<form action="/search.do">
		<input type="text" name="memberId" placeholder="아이디 입력">
		<input type="submit" value="조회">
	</form>
	<hr>
	<form action="/login.do">
		아이디 : <input type="text" name="memberId"><br>
		비밀번호 : <input type="password" name="memberPw"><br>
		<input type="submit" value="로그인">
	</form>
</body>
</html>