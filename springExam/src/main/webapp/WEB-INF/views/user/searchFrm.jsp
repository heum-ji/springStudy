<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>searchFrm</title>
</head>
<body>
	<h1>비밀번호 찾기</h1>
	<hr>
	<a href="/">홈으로</a>
	<br>
	<br>
	<form action="/searchPw.do" method="post">
		<fieldset>
			<legend>비밀번호 찾기</legend>
			이메일 : <input type="text" name="email"><br>
			이름 : <input type="text" name="userName"><br>
			<input type="submit" value="비밀번호 조회">
		</fieldset>
	</form>
</body>
</html>