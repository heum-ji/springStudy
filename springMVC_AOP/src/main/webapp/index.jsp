<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- JSTL Core 태그 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
	<h1>Spring MVC AOP</h1>
	<hr>
	<c:choose>
		<c:when test="${empty sessionScope.m }">
			<form action="/login.do">
				<fieldset>
					<legend>로그인</legend>
					아이디 : <input type="text" name="memberId"><br>
					비밀번호 : <input type="password" name="memberPw"><br>
					<input type="submit" value="로그인">
					<input type="reset" value="취소">
					<br>
					<a href="/joinFrm.do">회원가입</a>
					<a href="/searchFrm.do">아이디/비밀번호 찾기</a>
				</fieldset>
			</form>	
		</c:when>
		<c:otherwise>
			<h2>[ ${sessionScope.m.memberName } ]님 환영합니다.</h2>
			<h3><a href="/logout.do">로그아웃</a></h3>
			<h3><a href="/mypage.do?memberId=${sessionScope.m.memberId }">마이페이지</a></h3>
			<h3><a href="/allMember.do">전체회원조회</a></h3>
			<h3><a href="allMemberCount.do">전체회원 수 조회</a></h3>
			<h3><a href="/deleteMember.do?memberId=${sessionScope.m.memberId }">회원탈퇴</a></h3>
			<hr>
			<%-- 게시판 --%>
			<h3><a href="/boardWriteFrm.do">게시판 글쓰기</a></h3>
			<h3><a href="/boardList.do">게시판 목록</a></h3>
			<%-- 공지사항 --%>
			<h1><a href="/allNotice.do">공지사항</a></h1>
		</c:otherwise>
	</c:choose>
	
</body>
</html>