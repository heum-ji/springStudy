<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>couponList</title>
</head>
<body>
	<h1>쿠폰 리스트</h1>
	<hr>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>쿠폰 이름</th>
			<th>쿠폰 내용</th>
			<th>아이디</th>
			<th>시작 날짜</th>
			<th>종료 날짜</th>
			<th>상태</th>	
		</tr>
		<c:forEach items="${list }" var="coupon" varStatus="i">
			<tr>
				<td>${i.count }</td>
				<td>${coupon.couponName }</td>
				<td>${coupon.couponContent }</td>
				<td>${coupon.memberId }</td>
				<td>${coupon.startDate }</td>
				<td>${coupon.endDate }</td>
				<td>${coupon.status }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>