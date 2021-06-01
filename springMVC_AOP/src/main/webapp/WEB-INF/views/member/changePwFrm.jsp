<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>changePwFrm</title>
</head>
<body>
	<h1>비밀번호 수정</h1>
	<form action="/changePwMember.do" method="post">
		<input type="hidden" name="memberId"
			value="${sessionScope.m.memberId }"> 새로운 비밀번호 : <input
			name="memberPw" type="password" placeholder="비밀번호를 입력해주세요."><br>
		비밀번호 확인 : <input type="password" name="memberPwRe">
		<button type="button" onclick="checkPwRe(this.form);">수정</button>
	</form>
	<script>
		function checkPwRe(form) {
			var updatePw = form.memberPw.value; // 새 비밀번호
			var updatePwRe = form.memberPwRe.value; // 새 비밀번호 확인

			console.log(updatePw);
			console.log(updatePwRe);

			// 비번 공백 거르기
			if (updatePw != "") {
				// 비번 일치
				if (updatePw == updatePwRe) {
					form.submit(); // 비번 수정~!
				} else {
					alert("비밀번호가 맞지 않습니다.");
				}
			} else {
				alert("새 비밀번호를 입력해주세요.");
				form.memberPw.focus(); // 비번 입력 안했으니 입력창 포커스
			}
		}
	</script>
</body>
</html>