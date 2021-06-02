<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.3.1.js"></script>
</head>
<body>
	<h1>회원가입</h1>
	<hr>
	<form action="/join.do" method="post">
		아이디 : <input type="text" name="memberId"><span id="idChk"></span><br>
		비밀번호 : <input type="password" name="memberPw" required><br>
		이름 : <input type="text" name="memberName" required><br>
		전화번호 : <input type="text" name="phone" required><br>
		주소 : <input type="text" name="address"><br>
		성별 : 
		<input type="radio" name="gender" value="남">남자
		<input type="radio" name="gender" value="여">여자<br>
		<input type="submit" value="회원가입">
		<input type="reset" value="취소">
	</form>

	<script>
		$("[name=memberId]").on("keyup", function() {
			var memberId = $(this).val();

			$.ajax({
				url : "/checkId.do",
				data : { memberId : memberId },
				type : "get",
				success : function(data) {
					if (data == 1) { // 아이디 체크된 경우
						$("#idChk").html("해당 아이디는 사용 가능합니다.");
						$("#idChk").css("color", "blue");
					} else {
						$("#idChk").html("중복된 아이디 입니다."); // 아이디 중복
						$("#idChk").css("color", "red");
					}
				}
			});
		});
	</script>
</body>
</html>