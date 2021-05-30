<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>allNotice</title>
</head>
<body>
	<h1>공지사항 목록</h1>
	<hr>
	<a href="/">홈으로</a>
	<a href="/noticeWriteFrm.do">글쓰기</a>
	<br>
	<br>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		<c:forEach items="${list }" var="notice" varStatus="i">
			<tr>
				<th>${i.count }</th>
				<td><a href="/noticeView.do?noticeNo=${notice.noticeNo }">${notice.noticeTitle }</a></td>
				<td>${notice.noticeWriter }</td>
				<td>${notice.noticeDate }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>