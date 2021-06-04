<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
	<h1>SpringExam</h1>
	<hr>
	<c:choose>
		<c:when test="${empty sessionScope.u }">
			<form action="/login.do">
				<fieldset>
					<legend>로그인</legend>
					 이메일 : <input type="text" name="email"><br>
					 비밀번호 : <input type="password" name="userPw"><br>
					<input type="submit" value="로그인">
					<input type="reset" value="취소">
					<br>
					<a href="/joinFrm.do">회원가입</a>
					<a href="/searchPwFrm.do">비밀번호 찾기</a>
				</fieldset>
			</form>
		</c:when>
		<c:otherwise>
			<h2>[ ${sessionScope.u.userName } ]님 환영합니다.</h2>
			<h3><a href="/logout.do">로그아웃</a></h3>
			<h3><a href="/myinfo.do">내 정보</a></h3>				
			<h3><a href="/deleteUser.do">회원탈퇴</a></h3>
		</c:otherwise>
	</c:choose>
</body>
</html>