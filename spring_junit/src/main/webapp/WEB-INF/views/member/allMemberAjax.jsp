<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>allMemberAjax</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-3.3.1.js"></script>
</head>
<body>
	<h1>전체회원조회(AJAX)</h1>
	<hr>
	<button id="btn">전체회원 정보 불러오기</button>
	<div id="result"></div>
	<script>
		$("#btn").on("click", function() {
			$.ajax({
				url : "/allMemAjax.do",
				success : function(data) {
					var table = $("<table border='1'>");
					var titleTr = $("<tr>");
					
					titleTr.append("<th>아이디</th><th>이름</th><th>전화번호</th><th>주소</th><th>성별</th>");
					table.append(titleTr);
					
					$.each(data, function (index, item) {
						var tr = $("<tr>");
						
						tr.append("<td>" + item.memberId + "</td>");
						tr.append("<td>" + item.memberName + "</td>");
						tr.append("<td>" + item.phone + "</td>");
						tr.append("<td>" + item.address + "</td>");
						tr.append("<td>" + item.gender + "</td>");
						
						table.append(tr);
					});
					
					/* for(var i = 0; i < data.length; i ++) {
						var tr = $("<tr>");
						
						tr.append("<td>" + data[i].memberId + "</td>");
						tr.append("<td>" + data[i].memberName + "</td>");
						tr.append("<td>" + data[i].phone + "</td>");
						tr.append("<td>" + data[i].address + "</td>");
						tr.append("<td>" + data[i].gender + "</td>");
						
						table.append(tr);
					} */
					$("#result").append(table);
				}
			});
		});
	</script>
</body>
</html>