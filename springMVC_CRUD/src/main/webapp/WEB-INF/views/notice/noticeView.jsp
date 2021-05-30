<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticeView</title>
</head>
<body>
	<h1>공지사항 상세보기</h1>
	<hr>
	<div style="width:335px;">
		<table border="1">
			<tr>
				<th colspan="3">제목</th>
				<td colspan="3">${notice.noticeTitle }</td>
			</tr>
			<tr>
				<th>글번호</th>
				<td>${notice.noticeNo }</td>
				<th>작성자</th>
				<td>${notice.noticeWriter }</td>
				<th>작성일</th>
				<td>${notice.noticeDate }</td>
			</tr>
			<tr>
				<th colspan="3">내용</th>
				<td colspan="3">${notice.noticeContentBr }</td>
			</tr>
		</table>
		<c:if test="${sessionScope.m.memberId == notice.noticeWriter}">
			<div style="width:200px; margin: 0 auto; text-align: center;">
				<a href="/noticeUpdateFrm.do?noticeNo=${notice.noticeNo }">수정</a>
				<a href="/deleteNotice.do?noticeNo=${notice.noticeNo }">삭제</a>
			</div>
		</c:if>
	</div>
</body>
</html>