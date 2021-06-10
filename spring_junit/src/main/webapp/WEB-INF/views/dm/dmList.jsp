<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dmList</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-3.3.1.js"></script>
</head>
<body>
	<h1>DM LIST</h1>
	<hr>

	<h1>DM 보내기</h1>
	<input type="hidden" name="sender" value="${sessionScope.m.memberId }">
	받는 사람 : <input type="text" name="receiver" required>
	내용 : <input type="text" name="dmContent" required>
	<input type="button" value="보내기" onclick="sendDm();">
	<br>
	<br>

	<h2>받은 쪽지</h2>
	<table border="1">
		<tr>
			<th>쪽지번호</th>
			<th>보낸사람</th>
			<th>내용</th>
			<th>시간</th>
			<th>수신유무</th>
		</tr>
		<c:forEach items="${list }" var="dm">
			<c:if test="${dm.receiver == sessionScope.m.memberId}">
				<tr>
					<td>${dm.dmNo }</td>
					<td>${dm.sender }</td>
					<td>${dm.dmContent }</td>
					<td>${dm.dmTime }</td>
					<td>${dm.readStatus }</td>
				</tr>
			</c:if>
		</c:forEach>
	</table>

	<h2>보낸 쪽지</h2>
	<table border="1">
		<tr>
			<th>쪽지번호</th>
			<th>받는사람</th>
			<th>내용</th>
			<th>시간</th>
			<th>수신유무</th>
		</tr>
		<c:forEach items="${list }" var="dm">
			<c:if test="${dm.sender == sessionScope.m.memberId}">
				<tr>
					<td>${dm.dmNo }</td>
					<td>${dm.receiver }</td>
					<td>${dm.dmContent }</td>
					<td>${dm.dmTime }</td>
					<td>${dm.readStatus }</td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
	<hr>

	<script>
		function sendDm() {
			var sender = $("[name=sender]").val(); // 보내는이
			var receiver = $("[name=receiver]").val(); // 받는 사람
			var dmContent = $("[name=dmContent]").val(); // 내용

			$.ajax({
				url : "/sendDm.do",
				type : "post",
				data : {
					sender : sender,
					receiver : receiver,
					dmContent : dmContent
				},
				success : function(data) {
					location.href = "/dmList.do"
				}
			});
		}
	</script>
</body>
</html>