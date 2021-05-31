<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardView</title>
</head>
<body>
	<h1>게시물 상세보기</h1>
	<hr>
	<table border="1">
		<tr>
			<th colspan="1">제목</th>
			<td colspan="3">${board.boardTitle }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${board.boardWriter }</td>
			<th>작성일</th>
			<td>${board.boardDate }</td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td colspan="3">
				<!-- 첨부파일 -->
				 <c:forEach items="${board.fileList }" var="fileinfo">
					<a href="/fileDown.do">${fileinfo.filename }</a>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<th colspan="1">내용</th>
			<td colspan="3">${board.boardContentBr }</td>
		</tr>
		<tr>
		 	<!-- 수정/삭제 -->
			<th colspan="4">
				<a href="/boardList.do">목록으로</a>
				<c:if test="${sessionScope.m.memberId == board.boardWriter}">
					<a href="/boardUpdateFrm.do?boardNo=${board.boardNo }">수정</a>
					<a href="/deleteboard.do?boardNo=${board.boardNo }">삭제</a>
				</c:if>
			</th>
		</tr>
	</table>
</body>
</html>