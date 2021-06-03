<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myinfo</title>
<style>
/* 수정 불가 빨간색 테두리 */
fieldset>input:not([type="submit"]) {
	border: red solid 1px;
	outline: 0;
}

.pass-input:focus {
	/* outline: 0; */
	outline: blue solid 2px;
}
</style>

</head>
<body>
	<h1>회원 정보</h1>
	<hr>
	<a href="/">홈으로</a>
	<br>
	<br>
	<form action="/updateUser.do" method="post">
		<fieldset>
			<legend>회원 정보</legend>
			이메일 : <input type="text" name="email" disabled value=${sessionScope.u.email }><br>
			비밀번호 : <input style="border: blue solid 1px;" class="pass-input" type="password" name="userPw" value=${sessionScope.u.userPw }><br>
			이름 : <input type="text" name="userName" disabled value=${sessionScope.u.userName }><br>
			나이 : <input type="text" name="age" disabled value=${sessionScope.u.age }><br>
			<input type="submit" value="수정">
		</fieldset>
	</form>
</body>
</html>