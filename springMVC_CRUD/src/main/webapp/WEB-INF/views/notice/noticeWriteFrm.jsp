<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>공지사항 작성</h1>
	<form action="/noticeWrite.do">
	<input type="hidden" name="noticeWriter" value="${sessionScope.m.memberId }">
		<table border="1">
		<tr>
			<th>제목</th>
			<td><input type="text" name="noticeTitle" style="width:200px; height:20px; line-height:20px; border: none; outline: none;" placeholder="제목을 입력해 주세요." required></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="noticeContent" style="width:200px; height:300px; resize: none; border: none; outline: none;" placeholder="내용을 입력해 주세요." required></textarea></td>
			
		</tr>
		<tr>
			<th colspan="2"><input style="width: 100%" type="submit" value="완료"></th>
		</tr>
	</table>
	</form>
</body>
</html>